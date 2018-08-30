// function to validate a form
function validateForm() {
	if (validateName() && validateEmail() && validateAge()) {
		return true;
	} else {
		return false;
	}
}

// function to validate a name having length>=2
function validateName() {
	var fName = document.getElementById('firstName').value;
	var lName = document.getElementById('lastName').value;
	var pattern = /^[A-Za-z ]{2,}$/;
	if (pattern.test(fName) && pattern.test(lName)) {
		return true;
	} else if (!pattern.test(fName)) {
		if (fName.length < 2) {
			alert("First Name should be 2 characters long");
			return false;
		}
		alert("First Name can't contain numeric");
		return false;
	} else {
		if (lName.length < 2) {
			alert("Last Name should be 2 characters long");
			return false;
		}
		alert("Last Name can't contain numeric");
		return false;
	}
}

// function to validate an email.
function validateEmail() {
	var pattern = /^[a-zA-Z0-9\._]+@[a-zA-Z]+\.[a-zA-Z]+$/;
	if (!(pattern.test(document.getElementById('email').value))) {
		alert("Not a valid e-mail address");
		return false;
	} else {
		return true;
	}
}

// function to validate age
function validateAge() {
	var age = document.getElementById('age');
	if (age.value == "") {
		alert("Age can't be empty");
		return false;
	} else if (age.value >= 18 && age.value <= 65) {
		return true;
	} else {
		alert("Age must be between 18 and 65");
		return false;
	}
}

// function to validate search functionality
function validateSearch() {
	var name = document.getElementById("name");
	var pattern = /^[A-Za-z ]+$/;
	if (name.value.length < 1) {
		alert("Name can't be empty");
		return false;
	} else if (!pattern.test(name.value)) {
		alert("Please enter correct name");
		return false;
	} else {
		return true;
	}
}