import { Persona } from './../../../_model/persona';
import { Carta } from './../../../_model/carta';
import { TipoCarta } from './../../../_model/tipocarta';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { TipoCartaService } from 'src/app/_services/tipocarta.service';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-carta',
  templateUrl: './carta.component.html',
  styleUrls: ['./carta.component.css']
})
export class CartaComponent implements OnInit {
  
  aquienva: string;
  idiomaFavorito: string;
  seasons: string[] = ['A quien Interese', 'Persona'];
  idiomas: string[] = ['Espanol', 'Ingles', 'Frances', 'Italiano', 'Aleman'];

  displayedColumns = ['idTipoCarta', 'nombre','acciones'];
  dataSource: MatTableDataSource<TipoCarta>;

  persona1: Persona;
  

  constructor(private tipoCartaService: TipoCartaService,private dialog : MatDialog, private snackBar: MatSnackBar, public route: ActivatedRoute) { }

  ngOnInit(): void {

    this.persona1 = new Persona();
    this.persona1.nombres = "";
    this.persona1.apellidos = "";
    this.persona1.cargo = "";
    this.persona1.direccion= "";
    this.persona1.detalles = "";
    this.persona1.organizacion = "";
    this.persona1.ciudad = "";
    this.persona1.pais = "";

    this.tipoCartaService.buscarxIdioma("Espanol").subscribe(data => {
       console.log(data);
       this.dataSource = new MatTableDataSource(data);
      // this.dataSource.sort = this.sort;
       //this.dataSource.paginator = this.paginator;
     });
 
  }

  radioChange(event: any){

    this.tipoCartaService.buscarxIdioma(event.value).subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
     // this.dataSource.sort = this.sort;
      //this.dataSource.paginator = this.paginator;
    });
    

  }


  descargarReporte(idTipoCarta: number){
    let tipo = new TipoCarta();
    let carta = new Carta();
    let persona = new Persona();

    if(this.aquienva == "Persona"){
      persona.nombres = this.persona1.nombres;
      persona.apellidos =this.persona1.apellidos;
      persona.cargo = this.persona1.cargo;
      persona.direccion = this.persona1.direccion;
      persona.detalles = this.persona1.detalles;
      persona.organizacion = this.persona1.organizacion;
      persona.ciudad = this.persona1.ciudad;
      persona.pais = this.persona1.pais;
    }else{
      persona.nombres = "";
      persona.apellidos ="";
      persona.cargo = "";
      persona.direccion = "";
      persona.detalles = "";
      persona.organizacion = "";
      persona.ciudad = "";
      persona.pais = "";
    }
    carta.destino = this.aquienva;
    carta.persona = persona;

    this.tipoCartaService.listarPorId(idTipoCarta).subscribe(data => {
      carta.tipocarta = data;
        this.enviar(carta);      
    });

    //console.log(tipoCarta.idTipoCarta);
    /*
    */
  }

enviar(carta: Carta){
  this.tipoCartaService.generarReporte(carta).subscribe(data2 => {
    
    const url = window.URL.createObjectURL(data2);
    const a = document.createElement('a');
    a.setAttribute('style', 'display:none');
    document.body.appendChild(a);
    a.href = url;
    a.download = 'archivo.pdf'
    a.click();

  });
}
}
