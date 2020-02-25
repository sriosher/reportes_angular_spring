import { Carta } from './../_model/carta';
import { TipoCarta } from './../_model/tipocarta';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class TipoCartaService {
  url: string = `${environment.HOST}/tipos`;
  url2: string = `${environment.HOST}/tipos/generarReporte`;
  //sujeto
  tipoCartaCambio = new Subject<TipoCarta[]>();
  mensajeCambio = new Subject<string>();
  buscarCambio = new Subject<TipoCarta>();


  constructor(private http: HttpClient, private snackBar: MatSnackBar) { }

  listar() {
    return this.http.get<TipoCarta[]>(this.url);
  }
 
  

  listarPorId(idTipoCarta: number) {
    return this.http.get<TipoCarta>(`${this.url}/${idTipoCarta}`);
  }

  buscarxIdioma(idioma: String) {
    return this.http.get<TipoCarta[]>(`${this.url}/buscarporidioma/${idioma}`);
  }

  registrar(tipoCarta: TipoCarta) {
    return this.http.post(this.url, tipoCarta);
  }

  modificar(tipoCarta: TipoCarta) {
    return this.http.put(this.url, tipoCarta);
  }

  eliminar(idTipoCarta: number) {
    return this.http.delete(`${this.url}/${idTipoCarta}`);
  }

  generarReporte(carta: Carta){
    return this.http.post(this.url2, carta, {
      responseType: 'blob'
    });
  }

}
