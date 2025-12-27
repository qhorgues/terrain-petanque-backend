package com.polytech.terrainpetanque.exception;

import java.io.Serial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class represents a exception of Bad Request
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The request sent is invalid.")
public class BadRequestException extends RuntimeException {

    /**
     * This attribute is the serial number of the exception.
     */
    @Serial
    private static final long serialVersionUID = 669710082101113L;

}
