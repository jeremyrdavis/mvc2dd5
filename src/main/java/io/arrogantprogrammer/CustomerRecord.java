package io.arrogantprogrammer;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerRecord(
        @JsonProperty("id") Long id,
        @JsonProperty("email") String email,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName) {
}
