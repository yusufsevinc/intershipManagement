package com.intership.internshipmanagement.dto.converter;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.TeacherDto;
import com.intership.internshipmanagement.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherDtoConverter {

    public TeacherDto convert(Teacher from){
        try {
            return new TeacherDto(
                    from.getId(),
                    from.getEmail(),
                    from.getFirstName(),
                    from.getLastName(),
                    from.getPhone(),
                    from.getPhotoURL(),
                    from.getUniversities(),
                    from.getUniversityDepartments()

            );
        }catch (Exception e){
            throw  new NotFoundException(Message.errorTeacherGetById);
        }
    }
}
