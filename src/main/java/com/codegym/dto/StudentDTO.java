package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer studentId;
    private Byte studentGender;
//    @NotNull(message = "Họ và tên phụ huynh không được để trống")
//    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s ]*$", message = "Họ và tên phụ huynh không được nhập số hoặc ký tự đặc biệt")
//    @Size(min = 5, max = 50, message = "Họ và tên phụ huynh phải lớn hơn 5 và nhỏ hơn 50")
    private String studentFatherName;
//    @NotNull(message = "Họ và tên phụ huynh không được để trống")
//    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s ]*$", message = "Họ và tên phụ huynh không được nhập số hoặc ký tự đặc biệt")
//    @Size(min = 5, max = 50, message = "Họ và tên phụ huynh phải lớn hơn 5 và nhỏ hơn 50")
    private String studentMotherName;
//    @NotBlank(message = "Ngày sinh không được để trống.")
    private String studentDateOfBirth;
//    @NotNull(message = "Dân tộc không được để trống.")
    private String studentEthnicity;
//    @NotNull(message = "Quê quán không được để trống.")
//    @NotBlank
    private String studentAddress;
//    @NotNull(message = "Họ và tên học sinh không được để trống")
//    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s ]*$", message = "Họ và tên học sinh không được nhập số hoặc ký tự đặc biệt")
//    @Size(min = 5, max = 50, message = "Họ và tên học sinh phải lớn hơn 5 và nhỏ hơn 50")
    private String studentName;
    private String studentReligion;
    private String studentImage;
    private String studentStatus;
    //    @Pattern(regexp = "^(09[0|3])+([0-9]{7})\\b$", message = "Số điện thoại sai định dạng." +
//            "\n VD:090xxxxxxx, x gồm 7 chữ số")
    private String studentParentPhone;

}
