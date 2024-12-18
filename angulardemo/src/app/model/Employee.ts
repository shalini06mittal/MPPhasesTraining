export interface Employee{
    
    eid:number,
    ename:string,
    email:string,
    phone:string,
    password:string,
    address:{
         city?:string,
         country:string,
         zipcode?:number
     }
}