import { Component } from '@angular/core';
import { DemoService } from './demo.service';

@Component({
  selector: 'app-service',
  standalone: false,
  providers:[DemoService],
  templateUrl: './service.component.html',
  styleUrl: './service.component.css'
})
export class ServiceComponent {
  constructor(public service:DemoService){}
}
