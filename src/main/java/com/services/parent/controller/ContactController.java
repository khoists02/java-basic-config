package com.services.parent.controller;

import com.services.protobuf.TestProtos;
import com.services.parent.utils.PageableHelper;
import com.services.parent.dto.contacts.ContactRequest;
import com.services.parent.dto.contacts.ContactResponse;
import com.services.parent.dto.contacts.ContactsResponse;
import com.services.parent.model.Contact;
import com.services.parent.repositories.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
@Validated
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PageableHelper pageableHelper;

    @Autowired
    private ModelMapper mapper;

    @GetMapping()
    @Transactional(readOnly = true)
    public ContactsResponse getContacts(@PageableDefault Pageable pageable) {
        Slice<Contact> rs = contactRepository.findAll(pageable);
        ContactsResponse contacts = new ContactsResponse();
        List<ContactResponse> content = rs.getContent().stream().map(t -> {
            ContactResponse response = mapper.map(t, ContactResponse.class);
            response.setId(t.getId().toString());
            response.setFullName(t.getFirstName() + " " + t.getLastName());
            return  response;
        }).toList();
        contacts.setContent(content);
        contacts.setPageable(
                pageableHelper.mapPage(rs.getPageable().getPageNumber(),
                        rs.getPageable().getPageSize(),
                        rs.getNumberOfElements(),
                        (int) ((PageImpl<?>) rs).getTotalElements()));
        return  contacts;
    }

    @Transactional
    @PostMapping
    public Contact createContact(@Valid @RequestBody ContactRequest request) throws Exception {
        try {
            Contact contact = mapper.map(request, Contact.class);
            return contactRepository.save(contact);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            throw new Exception(exception);
        }
    }

    @GetMapping("/protobuf")
    public TestProtos.Student getStudent() {
        TestProtos.Student.Builder buider = TestProtos.Student.newBuilder();
        buider.setId(123);
        buider.setFirstName("132");

        return buider.build();
    }
}
