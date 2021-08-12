package com.intership.internshipmanagement.dto.converter;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.CompanyDto;
import com.intership.internshipmanagement.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyDtoConverter {

    public CompanyDto convert(Company from){
        try {
            return new CompanyDto(from.getId(),
                    from.getEmail(),
                    from.getName(),
                    from.getWebAddress(),
                    from.getAddress(),
                    from.getCity().getCityId());
        }catch (Exception e){
            throw  new NotFoundException(Message.errorCityGetById);
            }

    }

}
