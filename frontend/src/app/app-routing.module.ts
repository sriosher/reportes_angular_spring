import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { RouterModule } from "@angular/router";
import { Routes } from '@angular/router';
import { ReporteComponent } from './pages/reporte/reporte.component';
import { CartaComponent } from './pages/reporte/carta/carta.component';



const routes: Routes = [
  { path: '', component: ReporteComponent, children:[
    { path: 'carta', component: CartaComponent },
    
  ]},
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
