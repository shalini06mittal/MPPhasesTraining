console.log('hello');
var amount = 10;
function display(a, b) {
    return a + b;
}
function showDetails(obj) {
    console.log(obj.name + " " + obj.city);
}
showDetails({ name: 'asldkj' });
// amount ="hello";
// tsc -> typescript compiler -> .js
var Student = /** @class */ (function () {
    function Student(name) {
        this.name = name;
    }
    Student.prototype.showName = function () {
        console.log(this.name);
    };
    return Student;
}());
var s1 = new Student('John');
s1.showName();
