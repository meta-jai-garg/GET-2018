//Circle
var canvasCircle = document.getElementById('canvas-circle');
var contextCircle = canvasCircle.getContext('2d');

contextCircle.beginPath();
contextCircle.arc(50, 50, 40, 0, 2 * Math.PI);
contextCircle.fillStyle = '#2E94D1';
contextCircle.fill();
contextCircle.closePath();

//SemiCircle
var canvasSemiCircle = document.getElementById('canvas-semi-circle');
var contextSemiCircle = canvasSemiCircle.getContext('2d');

contextSemiCircle.beginPath();
contextSemiCircle.arc(50, 50, 40, 0.5 * Math.PI, 1.5 * Math.PI);
contextSemiCircle.fillStyle = '#2E94D1';
contextSemiCircle.fill();
contextSemiCircle.closePath();
contextSemiCircle.beginPath();
contextSemiCircle.arc(50, 50, 40, 1.5 * Math.PI, 0.5 * Math.PI);
contextSemiCircle.fillStyle = '#979B9C';
contextSemiCircle.fill();
contextSemiCircle.closePath();
contextSemiCircle.beginPath();
contextSemiCircle.arc(50, 50, 30, 1.5 * Math.PI, 0.5 * Math.PI);
contextSemiCircle.fillStyle = '#FFF';
contextSemiCircle.fill();
contextSemiCircle.closePath();


//HoloCircle
var canvasHoloCircle = document.getElementById('canvas-holo-circle');
var contextHoloCircle = canvasHoloCircle.getContext('2d');

contextHoloCircle.beginPath();
contextHoloCircle.arc(50, 50, 40, 0, 2 * Math.PI);
contextHoloCircle.fillStyle = '#982068';
contextHoloCircle.fill();
contextHoloCircle.closePath();
contextHoloCircle.beginPath();
contextHoloCircle.arc(50, 50, 30, 0, 2 * Math.PI);
contextHoloCircle.fillStyle = '#FFF';
contextHoloCircle.fill();
contextHoloCircle.closePath();

//Plus
var canvasPlus = document.getElementById('canvas-plus');
var contextPlus = canvasPlus.getContext('2d');

contextPlus.beginPath();
contextPlus.arc(50, 50, 40, 0, 2 * Math.PI);
contextPlus.fillStyle = '#FCB03C';
contextPlus.fill();
contextPlus.closePath();
contextPlus.beginPath();
contextPlus.rect(20, 45, 60, 10);
contextPlus.fillStyle = '#FFF';
contextPlus.fill();
contextPlus.closePath();
contextPlus.beginPath();
contextPlus.rect(45, 20, 10, 60);
contextPlus.fillStyle = '#FFF';
contextPlus.fill();
contextPlus.closePath();

//Triangle
var canvasTriangle = document.getElementById('canvas-triangle');
var contextTriangle = canvasTriangle.getContext('2d');

contextTriangle.beginPath();
contextTriangle.moveTo(50, 10);
contextTriangle.lineTo(90, 90);
contextTriangle.lineTo(10, 90);
contextTriangle.lineTo(50, 10);
contextTriangle.fillStyle = "#982068";
contextTriangle.fill();
contextTriangle.closePath();

//Rectangle
var canvasRectangle = document.getElementById('canvas-rectangle');
var contextRectangle = canvasRectangle.getContext('2d');

contextRectangle.beginPath();
contextRectangle.rect(10, 10, 80, 80);
contextRectangle.fillStyle = '#166432';
contextRectangle.fill();
contextRectangle.closePath();