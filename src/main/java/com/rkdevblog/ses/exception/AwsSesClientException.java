package com.tokoin.otp.exception;

/**
 * This exception used in AwsService
 */
public class AwsSnsClientException extends OTPServiceException {

    /**
     * Aws client Exception
     *
     * @param errorMessage error message
     */
    public AwsSnsClientException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Aws Client Exception with error message and throwable
     *
     * @param errorMessage error message
     * @param throwable    error
     */
    public AwsSnsClientException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

}
