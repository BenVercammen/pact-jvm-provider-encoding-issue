package pact.issue;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class Controller {

    @PutMapping("/address/{id}")
    public @ResponseBody
    ResponseEntity<AddressDto> wijzigAdres(@PathVariable("id") Long id, @RequestBody @Valid AddressDto addressDto) {
        return ok(addressDto);
    }

    static class AddressDto {
        @NotEmpty
        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

}
