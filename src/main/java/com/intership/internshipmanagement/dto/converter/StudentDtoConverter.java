package com.intership.internshipmanagement.dto.converter;

import com.intership.internshipmanagement.core.exception.NotFoundException;
import com.intership.internshipmanagement.core.message.Message;
import com.intership.internshipmanagement.dto.StudentDto;
import com.intership.internshipmanagement.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoConverter {
    public StudentDto convert(Student from){
        try{
            return new StudentDto(
                    from.getId(),
                    from.getFirstName(),
                    from.getLastName(),
                    from.getStudentNo(),
                    from.getClassNo(),
                    from.getPhotoURL(),
                    from.getEmail(),
                    from.getPhone(),
                    from.getCompany().getId(),
                    from.getDepartment().getDepartmentId(),
                    from.getTeacher().getId(),
                    from.getUniversityStudent().getUniversityId(),
                    from.getUniversityDepartmentStudent().getUniversityDepartmentId(),
                    from.getStatus().name());



        }catch (Exception e){
            throw  new NotFoundException(Message.errorStudentGetById);
        }
    }

}
