import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Button } from 'selenium-webdriver';
import { Visitor } from './visitor';
import { VisitorService } from './visitor.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public visitors: Visitor[];
  public editVisitor: Visitor;
  public deleteVisitor: Visitor;
  
  constructor(private visitorService: VisitorService){}

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


  public onAddVisitor(addForm: NgForm): void 
  {
    document.getElementById('add-visitor-form')?.click();
    this.visitorService.addVisitor(addForm.value).subscribe(
      (response: Visitor)=>
      {
        console.log(response);
        this.getVisitors();
        addForm.reset();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    );
  }


  public onUpdateVisitor(visitor: Visitor): void 
  {
    
    this.visitorService.updateVisitor(visitor).subscribe(
      (response: Visitor)=>
      {
        console.log(response);
        this.getVisitors();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }


  public onDeleteVisitor(visitorId: number): void 
  {
    
    this.visitorService.deleteVisitor(visitorId).subscribe(
      (response: void)=>
      {
        console.log(response);
        this.getVisitors();
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }



  public onOpenModal(visitor:Visitor, mode:string): void
  {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode === 'add')
    {
      button.setAttribute('data-target', '#addVisitorModal');
    }

    if(mode === 'edit')
    {
      this.editVisitor = visitor;
      button.setAttribute('data-target', '#updateVisitorModal');
    }

    if(mode === 'delete')
    {
      this.deleteVisitor = visitor;
      button.setAttribute('data-target', '#deleteVisitorModal');
    }

    container?.appendChild(button);
    button.click();
  }
  
}
