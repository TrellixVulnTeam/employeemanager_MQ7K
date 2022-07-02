import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  addEmpUrl : string;
  getEmpUrl : string;
  updateEmpUrl : string;
  deleteEmpUrl : string;

  constructor(private http : HttpClient) { 
    this.addEmpUrl = 'http://localhost:8080/emp/addEmployee';
    this.getEmpUrl = 'http://localhost:8080/emp/getAll';
    this.updateEmpUrl = 'http://localhost:8080/emp/updateEmployee';
    this.deleteEmpUrl = 'http://localhost:8080/emp/deleteEmployeeById';
  }


  addEmployee(emp : Employee): Observable<Employee> {
    return this.http.post<Employee>(this.addEmpUrl, emp);
  }

  getAllEmployee(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.getEmpUrl);
  }

  updateEmployee(emp : Employee) : Observable<Employee> {
    return this.http.put<Employee>(this.updateEmpUrl, emp);
  }

  deleteEmployee(emp : Employee) : Observable<Employee> {
     return this.http.delete<Employee>(this.deleteEmpUrl+'/'+emp.id);
   }
}
