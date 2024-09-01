package com.example.putera_demo.exception;

import java.util.Date;

public record ErrorDetails(Date timestamp, String message, String details) {}

