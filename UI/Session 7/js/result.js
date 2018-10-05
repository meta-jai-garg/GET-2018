window.onload = function () {
  var firstName = document.getElementById('firstName'),
    lastName = document.getElementById('lastName'),
    email = document.getElementById('email'),
    phone = document.getElementById('phone'),
    address = document.getElementById('address'),
    city = document.getElementById('city'),
    state = document.getElementById('state');

  firstName.value = localStorage.getItem('firstName');
  lastName.value = localStorage.getItem('lastName');
  email.value = localStorage.getItem('email');
  phone.value = localStorage.getItem('phone');
  address.value = localStorage.getItem('address');
  city.value = localStorage.getItem('city');
  state.value = localStorage.getItem('state');
  firstName.readOnly = true;
  lastName.readOnly = true;
  email.readOnly = true;
  phone.readOnly = true;
  address.readOnly = true;
  city.readOnly = true;
  state.readOnly = true;

  if (state.value === 'Rajasthan') {
    var website = createElement('website', 'Website or Domain Name', 'fa fa-globe-americas icon');
    website.value = localStorage.getItem('website');
    website.readOnly = true;
    var description = createElement('description', 'Project Description', 'fa fa-pencil-alt icon');
    description.value = localStorage.getItem('description');
    description.readOnly = true;
  } else if (state.value === 'Haryana') {
    var zip = createElement('zipCode', 'Zip-Code', 'fa fa-home icon');
    zip.value = localStorage.getItem('zipCode');
    zip.readOnly = true;
    var hosting = createElement('hosting', 'Do you have hosting?', 'fa fa-server icon');
    hosting.value = localStorage.getItem('hosting');
    hosting.readOnly = true;
  } else {
    var zip = createElement('zipCode', 'Zip-Code', 'fa fa-home icon');
    zip.value = localStorage.getItem('website');
    zip.readOnly = true;
    var description = createElement('description', 'Project Description', 'fa fa-pencil-alt icon');
    description.value = localStorage.getItem('description');
    description.readOnly = true;
  }

};

// function to create dynamic div elements
function createElement(id, labelText, faClass) {
  var div = document.createElement('div'),
    label = document.createElement('label'),
    i = document.createElement('i'),
    input = document.createElement('input');
  div.setAttribute('class', 'input-container dynamic-div');
  label.setAttribute('for', id);
  label.appendChild(document.createTextNode(labelText));
  i.setAttribute("class", faClass);
  input.type = 'text';
  input.id = id;
  div.appendChild(label);
  div.appendChild(i);
  div.appendChild(input);
  console.log(div);
  document.getElementById('myFormResult').append(div);
  return document.getElementById(id);
}
