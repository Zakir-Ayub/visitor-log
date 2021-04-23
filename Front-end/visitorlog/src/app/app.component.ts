import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Visitor } from './visitor';
import { VisitorService } from './visitor.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public visitors: Visitor[];
  constructor(private visitorService: VisitorService)
  {
    this.visitors = [];
  }

  ngOnInit()
  {
    this.getVisitors();
  }

  public getVisitors():void
  {
    this.visitorService.getVisitors().subscribe(
      (response:Visitor[])=> {
        this.visitors = response;
      },
      (error:HttpErrorResponse)=>
      {
        alert(error.message);
      }
    );
  }
  
}
