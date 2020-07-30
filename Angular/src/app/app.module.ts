import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListAllOrdersComponent } from './list-all-orders/list-all-orders.component';
import { EditOrderDetailsComponent } from './edit-order-details/edit-order-details.component';
import { ViewOrderDetailsComponent } from './view-order-details/view-order-details.component';
import { DeleteConfirmDialogComponent } from './delete-confirm-dialog/delete-confirm-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginAdminComponent } from './login-admin/login-admin.component';


@NgModule({
  declarations: [
    AppComponent,
    ListAllOrdersComponent,
    EditOrderDetailsComponent,
    ViewOrderDetailsComponent,
    DeleteConfirmDialogComponent,
    LoginAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatDialogModule,
    BrowserAnimationsModule,
    HttpClientModule,
   FormsModule,
   ReactiveFormsModule
  ],
  entryComponents: [DeleteConfirmDialogComponent],
  providers: [],
  bootstrap: [AppComponent], 
 
})
export class AppModule { 

}
