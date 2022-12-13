import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProglanguaappComponent } from './proglanguaapp/proglanguaapp.component';

const routes: Routes = [
  {path: '', component: ProglanguaappComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
