package org.garen.oss.swagger.api;

import io.swagger.annotations.ApiParam;
import org.garen.oss.exception.BusinessException;
import org.garen.oss.swagger.model.ModelApiResponse;
import org.garen.oss.swagger.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-08-24T01:49:38.472Z")

@Controller
public class PetApiController implements PetApi {

    public ResponseEntity<Void> addPet(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true ) @RequestBody Pet body) {
        // do some magic!
        throw new BusinessException("测试直接抛异常");
        //return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deletePet(@ApiParam(value = "Pet id to delete",required=true ) @PathVariable("petId") Long petId,
        @ApiParam(value = ""  ) @RequestHeader(value="api_key", required=false) String apiKey) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Pet>> findPetsByStatus(@ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "AVAILABLE, PENDING, SOLD") @RequestParam(value = "status", required = true) List<String> status) {
        // do some magic!
        return new ResponseEntity<List<Pet>>(HttpStatus.OK);
    }

    public ResponseEntity<List<Pet>> findPetsByTags(@ApiParam(value = "Tags to filter by", required = true) @RequestParam(value = "tags", required = true) List<String> tags) {
        // do some magic!
        return new ResponseEntity<List<Pet>>(HttpStatus.OK);
    }

    public ResponseEntity<Pet> getPetById(@ApiParam(value = "ID of pet to return",required=true ) @PathVariable("petId") Long petId) {
        // do some magic!
        throw new BusinessException("测试直接抛异常");
        //return new ResponseEntity<Pet>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updatePet(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true ) @RequestBody Pet body) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updatePetWithForm(@ApiParam(value = "ID of pet that needs to be updated",required=true ) @PathVariable("petId") Long petId,
        @ApiParam(value = "Updated name of the pet" ) @RequestPart(value="name", required=false)  String name,
        @ApiParam(value = "Updated status of the pet" ) @RequestPart(value="status", required=false)  String status) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<ModelApiResponse> uploadFile(@ApiParam(value = "ID of pet to update",required=true ) @PathVariable("petId") Long petId,
                                                       @ApiParam(value = "Additional data to pass to server" ) @RequestPart(value="additionalMetadata", required=false)  String additionalMetadata,
                                                       @ApiParam(value = "file detail") @RequestPart("file") MultipartFile file) {
        // do some magic!
        return new ResponseEntity<ModelApiResponse>(HttpStatus.OK);
    }

}
