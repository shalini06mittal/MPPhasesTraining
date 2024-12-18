console.log('hello');

let amount:number = 10;

function display(a:number,b:number):number{
    return a+b;
}
// basically used to specify the type of an object
interface Person{
    name:string,
    city?:string
}
function showDetails(obj:Person):void{
    console.log(obj.name+" "+obj.city);
    
}
showDetails({name:'asldkj'})

// amount ="hello";
// tsc -> typescript compiler -> .js

class Student{
    name:string
    constructor(name:string){
        this.name = name;
    }
    showName(){
        console.log(this.name);
        
    }
}
let s1 = new Student('John')
s1.showName();