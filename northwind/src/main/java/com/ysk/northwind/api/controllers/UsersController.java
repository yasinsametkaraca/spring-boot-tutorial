package com.ysk.northwind.api.controllers;

import com.ysk.northwind.business.abstracts.UserService;
import com.ysk.northwind.core.entities.User;
import com.ysk.northwind.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {//soru işaretinin anlamı hata da dönebilir success de. @Valid in anlamı validasyondan geçir demektir.
        return ResponseEntity.ok(this.userService.add(user));
    } //bu yaptığımız işlem hata verebilir. bu yüzden global hata yakalama tanımlamalıyız. hata durumunda bütün metodlarda çalışacak aop tanımlıcaz. bi kere yazıp bütün operasyonları oraya yollucaz. Hepsine tek tek try catch yazmak yerine bunu yapıcaz


    @ExceptionHandler(MethodArgumentNotValidException.class)  //bu sistemde şu tür hata olursa bunu devreye sokar. sistemde MethodArgumentNotValidException hatası olursa onu direk ResponseEntity bad requeste çevir.
    @ResponseStatus(HttpStatus.BAD_REQUEST) //bu metod default olarak bad request dönsün
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();  //key,value = mesela Email alanı formata uygun değil hatası. key=email,value=Email alanı formata uygun değil
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){            //alanlarda oluşan tüm hataları oku. FieldError = fieldlarda oluşan hatanın listesi.
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors =new ErrorDataResult<Object>(validationErrors,"Validation Errors");
        return errors;
    }

    //custom validation (mesela emailin tekrar edilmemesi) ve spring security işlemleri yapılacak


}
