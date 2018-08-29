// function to validate a form
function validateForm() {
    if (validateName() && validateEmail() && validatePassword() && validateConfirmPassword() && validateContact()) {
        return true;
    } else {
        return false;
    }
}

// function to validate a name having length>=2
function validateName(){
    var fName = document.getElementById('firstname').value;
    var lName = document.getElementById('lastname').value;
    var pattern = /^[A-Za-z ]{2,}$/;
    if(pattern.test(fName) && pattern.test(lName)){
        return true;
    }else if(!pattern.test(fName)){
        alert("first name is incorrect");
        return false;
    }else{
        alert("last name is incorrect");
        return false;
    }
}

// function to validate an email.
function validateEmail() {
    var email = document.getElementById('email');
    var atpos = email.value.indexOf("@");
    var dotpos = email.value.lastIndexOf(".");
    if (atpos >=1 && dotpos>=atpos+1 && dotpos < email.value.length-2) {
        return true;
    } else {
        alert("Not a valid e-mail address");
        return false;
    }        
}

// function to validate a password that contains atleast one lowercase, one uppercase, one special symbol, one digit and length>=8
function validatePassword() {
    var password = document.getElementById('password').value, errors = [];
    if (password.length < 8) {
        errors.push("Your password must be at least 8 characters");
    } if (password.search(/[a-z]/i) < 0) {
        errors.push("Your password must contain at least one letter."); 
    } if (password.search(/[\d]/) < 0) {
        errors.push("Your password must contain at least one digit.");
    } if(password.search(/[^a-zA-Z0-9]/) < 0){
        errors.push("Your password must contain at least one special symbol.");
    } if (errors.length > 0) {
        alert(errors.join("\n"));
        return false;
    }
    return true;
}

// function to match both entered password
function validateConfirmPassword(){
    debugger;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmpassword').value;
    if(password==confirmPassword){
        return true;
    }else{
        alert("Password is not matching");
        return false;
    }
}

// function to validate a contact number having length>8
function validateContact() {
    var pattern = /^[\d]{9,}/;
    if(pattern.test(contact.value)){
        return true;
    } else {
        alert("Invalid Contact");
        return false;
    }
}