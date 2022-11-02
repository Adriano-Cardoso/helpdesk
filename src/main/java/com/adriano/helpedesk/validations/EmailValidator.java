package com.adriano.helpedesk.validations;

import com.adriano.helpedesk.exception.BusinessException;
import com.adriano.helpedesk.exception.Message;
import com.adriano.helpedesk.repository.ClientRepository;
import com.adriano.helpedesk.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@AllArgsConstructor
@Component
@SupportedValidationTarget({ValidationTarget.PARAMETERS, ValidationTarget.ANNOTATED_ELEMENT})
public class EmailValidator implements ConstraintValidator<EmailValid, String> {

    private ClienteService clienteService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        try {

            clienteService.FindByEmail(email);

        } catch (BusinessException e){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addConstraintViolation();
            return false;

        }

        return true;
    }
}
