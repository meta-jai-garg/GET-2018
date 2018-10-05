// To store error messages
var errors;

// funtion to create zipcode field
function zipCode() {
  "use strict";
  var div = document.createElement('div'),
    label = document.createElement('label'),
    i = document.createElement('i'),
    input = document.createElement('input');
  div.setAttribute('class', 'input-container dynamic-div');
  label.setAttribute("for", "zipCode");
  label.appendChild(document.createTextNode("Zip-Code"));
  i.setAttribute("class", "fa fa-home icon");
  input.setAttribute("type", "text");
  input.setAttribute("id", "zipCode");
  input.setAttribute("placeholder", "Zip Code");
  div.appendChild(label);
  div.appendChild(i);
  div.appendChild(input);
  document.getElementById('myForm').append(div);
}

// funtion to create website field
function website() {
  "use strict";
  var div = document.createElement('div'),
    label = document.createElement('label'),
    i = document.createElement('i'),
    input = document.createElement('input');
  div.setAttribute('class', 'input-container dynamic-div');
  label.setAttribute("for", "website");
  label.appendChild(document.createTextNode("Website or Domain Name"));
  i.setAttribute("class", "fa fa-globe-americas icon");
  input.setAttribute("type", "text");
  input.setAttribute("id", "website");
  input.setAttribute("placeholder", "Website or Domain Name");
  div.appendChild(label);
  div.appendChild(i);
  div.appendChild(input);
  document.getElementById('myForm').append(div);
}

// funtion to create hosting field
function hosting() {
  "use strict";
  var div = document.createElement('div'),
    label = document.createElement('label'),
    radioDiv = document.createElement('div'),
    inputYes = createRadioBtn('hosting', 'Yes', 'Yes'),
    inputNo = createRadioBtn('hosting', 'No', 'No'),
    radioLabel = document.createElement('label');
  div.setAttribute('class', 'input-container dynamic-div');
  label.appendChild(document.createTextNode("Do you have hosting?"));
  radioDiv.setAttribute("id", "hostingDivRadio");
  radioDiv.appendChild(inputYes);
  radioDiv.appendChild(document.createElement('br'));
  radioDiv.appendChild(inputNo);
  div.appendChild(label);
  div.appendChild(radioDiv);
  document.getElementById('myForm').append(div);
}

// funtion to create project description field
function description() {
  "use strict";
  var div = document.createElement('div'),
    label = document.createElement('label'),
    i = document.createElement('i'),
    textArea = document.createElement('textarea');
  div.setAttribute('class', 'input-container dynamic-div');
  label.setAttribute("for", "description");
  label.appendChild(document.createTextNode("Project Description"));
  i.setAttribute("class", "fa fa-pencil-alt icon");
  textArea.setAttribute("rows", "4");
  textArea.setAttribute("cols", "24");
  textArea.setAttribute("id", "description");
  textArea.setAttribute("placeholder", "Project Description");
  textArea.name = 'Project Description';
  div.appendChild(label);
  div.appendChild(i);
  div.appendChild(textArea);
  document.getElementById('myForm').append(div);
}

// Function to create a radio button
function createRadioBtn(name, value, text) {
  var label = document.createElement('label');
  var radio = document.createElement('input');
  radio.type = 'radio';
  radio.name = name;
  radio.value = value;
  label.appendChild(radio);
  label.appendChild(document.createTextNode(text));
  return label;
}

// function to delete an element
function deleteElement() {
  var elements = document.getElementsByClassName('dynamic-div');
  while (elements.length > 0) {
    elements[0].parentNode.removeChild(elements[0]);
  }
}

// function to validata Text
function validateText(text) {
  "use strict";
  var pattern = /^([a-zA-Z ]{2,})+$/;
  if (pattern.test(text.value)) {
    return true;
  } else {
    errors.push(text.getAttribute('name') + ': It is invalid!');
    return false;
  }
}

// function to validate website url
function validateURL(url) {
  var pattern = /^(?:(?:https?|ftp):\/\/)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:\/\S*)?$/;
  if (pattern.test(url.value)) {
    return true;
  } else {
    /*alert("Website - It is invalid!");*/
    errors.push('Website : It is invalid!');
    return false;
  }
}

// function to validate email
function validateEmail(email) {
  "use strict";
  var pattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  if (pattern.test(email.value)) {
    return true;
  } else {
    errors.push('Email - It is invalid!');
    return false;
  }
}

// function to validate phone
function validatePhone(phone) {
  "use strict";
  var pattern = /^[\d]{9,}/;
  if (pattern.test(phone.value)) {
    return true;
  } else {
    errors.push('Phone - It is invalid!');
    return false;
  }
}

// function to validate zipcode
function validateZip(zip) {
  var pattern = /^[\d]{6}/;

  if (pattern.test(zip.value)) {
    return true;
  } else {
    errors.push('Zip Code - It is invalid');
    return false;
  }
}

// function to validate hositng field
function validateHosting(hosting) {
  var i = 0;
  var isChecked = false;
  while (i < hosting.length) {
    if (hosting[i].checked) {
      isChecked = true;
    }
    i++;
  }
  if (isChecked) {
    return true;
  } else {
    errors.push('Hosting : Please Choose a Hosting Option');
    return false;
  }
}

// function to store data 
function storeData(key, value) {
  localStorage.setItem(key, value);
}

// function to perform form validation
function formValidate() {
  "use strict";
  var firstName = document.getElementById('firstName'),
    lastName = document.getElementById('lastName'),
    email = document.getElementById('email'),
    phone = document.getElementById('phone'),
    address = document.getElementById('address'),
    city = document.getElementById('city'),
    state = document.getElementById('state');

  errors = [];

  localStorage.clear();

  if (validateText(firstName)) {
    storeData('firstName', firstName.value);
  }
  if (validateText(lastName)) {
    storeData('lastName', lastName.value);
  }
  if (validateEmail(email)) {
    storeData('email', email.value);
  }
  if (validatePhone(phone)) {
    storeData('phone', phone.value);
  }
  if (validateText(address)) {
    storeData('address', address.value);
  }
  if (validateText(city)) {
    storeData('city', city.value);
  }
  if (validateText(state)) {
    storeData('state', state.value);
  }
  if (state.value === 'Rajasthan') {
    var website = document.getElementById('website');
    var description = document.getElementById('description');
    if (validateURL(website)) {
      storeData('website', website.value);
    }
    if (validateText(description)) {
      storeData('description', description.value);
    }
  } else if (state.value === 'Haryana') {
    var zip = document.getElementById('zipCode');
    var hosting = document.getElementsByName('hosting');
    if (validateZip(zip)) {
      storeData('zipCode', zip.value);
    }
    if (validateHosting(hosting)) {
      storeData('hosting', document.querySelector("input[name='hosting']:checked").value);
    }
  } else if (state.value === 'Maharashtra') {
    var zip = document.getElementById('zipCode');
    var description = document.getElementById('description');
    if (validateZip(zip)) {
      storeData('zipCode', zip.value);
    }
    if (validateText(description)) {
      storeData('description', description.value);
    }
  }

  if (errors.length > 0) {
    alert(errors.join('\n'));
    return false;
  } else {
    return true;
  }
}

// Function to show Dynamic Divs
function showDiv(elem) {
  "use strict";
  if (elem.value === 'Rajasthan') {
    deleteElement();
    website();
    description();
  } else if (elem.value === 'Haryana') {
    deleteElement();
    zipCode();
    hosting();
  } else {
    deleteElement();
    zipCode();
    description();
  }
}
