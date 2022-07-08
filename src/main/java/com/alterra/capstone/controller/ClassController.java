package com.alterra.capstone.controller;

import com.alterra.capstone.entity.Class;
import com.alterra.capstone.payload.ClassPayload;
import com.alterra.capstone.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
@AllArgsConstructor
public class ClassController {

    private final ClassService service;

    @GetMapping
    public ResponseEntity<?> getAllClass(){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        try {
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Success Get All Class");
            baseResponse.setData(service.getAllClass());
        }catch (Exception e){
            baseResponse.setSuccess(false);
            baseResponse.setMessage(e.getMessage());
            return new ResponseEntity(baseResponse, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    //     GET CLASS BY USER ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getClassById(@PathVariable("id") Long id){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        if (service.getClassById(id) != null){
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Success Get Class By Id");
            baseResponse.setData(List.of(service.getClassById(id)));
        }else {
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed Get Class By Id");
            baseResponse.setData(null);
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }


//    @GetMapping("/user_id/{user_id}")
//    public BaseResponse<Class> getClassById(@PathVariable("id_class") Long id){
//        BaseResponse<Class> baseResponse = new BaseResponse<>();
//        baseResponse.setSuccess(true);
//        baseResponse.setMessage("Success Get Class By Id");
//        baseResponse.setData(service.getClassById(id));
//        return baseResponse;
//    }

    // GET CLAS BY USER ID
    @GetMapping("/user/{user_id}")
    public ResponseEntity<?> findClassByUser_Id(@PathVariable("user_id") Long user){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        if (service.findClassByUser_Id(user) != null){
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Success Get Class By User Id");
            baseResponse.setData(service.findClassByUser_Id(user));
        }else {
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed Get Class By User Id");
            baseResponse.setData(null);
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    // GET CLASS TYPE OFFLINE
    @CrossOrigin
    @GetMapping("/offline")
    public ResponseEntity<?> getClassTypeOffline(){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Get Class Type Offline");
        baseResponse.setData(service.getClassTypeOffline());
        return ResponseEntity.ok(baseResponse);
    }

    // GET CLASS TYPE ONLINE
    @GetMapping("/online")
    public ResponseEntity<?> getClassTypeOnline(){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Get Class Type Online");
        baseResponse.setData(service.getClassTypeOnline());
        return ResponseEntity.ok(baseResponse);
    }

//    @PostMapping("/online")
//    public ResponseEntity<?> createClassOnline(@RequestBody ClassPayload payload){

    @PostMapping("/online")
    public ResponseEntity<?> createNewClass(@RequestBody ClassPayload payload){
        BaseResponse<Class> baseResponse = new BaseResponse<>();
        if (payload.getName() != null &&
                !payload.getIdInstructor().getId().equals("") && payload.getIdInstructor().getId() != null &&
                !payload.getStartAt().equals("") && payload.getStartAt() != null &&
                !payload.getDescription().equals("") && payload.getDescription() != null &&
                !payload.getPrice().equals("") && payload.getPrice() != null &&
                !payload.getLocation().equals("") && payload.getLocation() != null){
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Success Create New Online Class");
            baseResponse.setData(service.createOnlineClass(payload));
        }else {
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed to Create Online Class");
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.CREATED);
    }

    @PostMapping("/offline")
    public ResponseEntity<?> createClassOffline(@RequestBody ClassPayload payload){
        BaseResponse<Class> baseResponse = new BaseResponse<>();
        if (!payload.getName().equals("") && payload.getName() != null &&
                !payload.getIdInstructor().getId().equals("") && payload.getIdInstructor().getId() != null &&
                !payload.getStartAt().equals("") && payload.getStartAt() != null &&
                !payload.getDescription().equals("") && payload.getDescription() != null &&
                !payload.getPrice().equals("") && payload.getPrice() != null &&
                !payload.getLocation().equals("") && payload.getLocation() != null){
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Success Create New Online Class");
            baseResponse.setData(service.createOfflineClass(payload));
        }else {
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed to Create Online Class");
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClass(@PathVariable("id") Long id, @RequestBody ClassPayload payload){
        BaseResponse<Class> baseResponse = new BaseResponse<>();
        try {
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Success Update Class");
            baseResponse.setData(service.updateClass(id,payload));
        }catch (Exception e){
            baseResponse.setSuccess(false);
            baseResponse.setMessage(e.getMessage());
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassById(@PathVariable("id") Long id){
        BaseResponse baseResponse = new BaseResponse();
        try {
            service.deleteClasById(id);
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Deleted");
        } catch (Exception e){
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Delete failed");
            return new ResponseEntity(baseResponse, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }
}
