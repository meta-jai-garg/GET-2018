import { sayHello } from './modules/greeting';
import { sum, product } from './modules/math-functions';

const resultGreeting = document.getElementById('resultGreeting');
const resultSum = document.getElementById('resultSum');
const resultProduct = document.getElementById('resultProduct');
const showSum = document.getElementById('sum');
const showMulti = document.getElementById('multiply');

resultGreeting.textContent = sayHello('Nice to see you! 😂');

resultSum.style.display = 'none';
resultProduct.style.display = 'none';

const a = 3;
const b = 2;

showSum.addEventListener('click', function () {
    resultSum.style.display = 'block';
    resultSum.textContent = `The sum of ${a} and ${b} is ${sum(a, b)}. ✨`;
});

showMulti.addEventListener('click', function () {
    resultProduct.style.display = 'block';
    resultProduct.textContent = `The product of ${a} and ${b} is ${product(a, b)}. 🚀`;
});