import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListAllOrdersComponent } from './list-all-orders/list-all-orders.component';
import { ViewOrderDetailsComponent } from './view-order-details/view-order-details.component';
import { EditOrderDetailsComponent } from './edit-order-details/edit-order-details.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  {path:'listAllOrder',component:ListAllOrdersComponent},
  {path:'viewOrder',component:ViewOrderDetailsComponent},
  {path:'editOrder/:id',component:EditOrderDetailsComponent},
  {path:'loginAdmin',component:LoginAdminComponent},
  
  {path:'',redirectTo:"/loginAdmin",pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
