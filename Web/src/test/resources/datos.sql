insert into Administrador values ("1111111111","admin@gmail.com","Carlos","root",1);

insert into Actor values (1,"Zac Efron");
insert into Actor values(2,"Emilia Clarke");
insert into Actor values(3,"Sofia Vergara");
insert into Actor values(4,"Zac Efron");
insert into Actor values(5,"Zac Efron");

insert into  Ciudad values (1,"Armenia");
insert into Ciudad values (2,"Medellin");
insert into Ciudad values (3,"Pereira");
insert into Ciudad values (4,"Bogota");
insert into Ciudad values (5,"Cali");

insert into administrador_ciudad values ("1111111112","adminArmenia@gmail.com","Raul perez","root",1,1);
insert into administrador_ciudad values ("1111111113","adminMedellin@gmail.com","Raul perez","root",2,2);
insert into administrador_ciudad values ("1111111123","adminPereira@gmail.com","Mario Quita","root",3,3);
insert into administrador_ciudad values ("1111111124","adminBogota@gmail.com","Sandra Liz","root",4,4);
insert into administrador_ciudad values ("1111111126","adminCali@gmail.com","Pepito Perez","root",5,5);

insert into cliente values ("1005278617","emerson@gmail.com","Emerson Pulgarin","k+jijKQL/TpgnJyANoZnUymCqy1AoHO0ybqHn6ZV0Zve6i3tIk6YvZzMqYw9RZCE ","");
insert into cliente values ("1005278618","juana@gmail.com","Juana Restrepo","k+jijKQL/TpgnJyANoZnUymCqy1AoHO0ybqHn6ZV0Zve6i3tIk6YvZzMqYw9RZCE ","");
insert into cliente values ("1005278619","natalia@gmail.com","Natalia Vargaz","k+jijKQL/TpgnJyANoZnUymCqy1AoHO0ybqHn6ZV0Zve6i3tIk6YvZzMqYw9RZCE ","");
insert into cliente values ("1005278613","andres@gmail.com","Andres Posada","k+jijKQL/TpgnJyANoZnUymCqy1AoHO0ybqHn6ZV0Zve6i3tIk6YvZzMqYw9RZCE ","");
insert into cliente values ("1005278612","miguel@gmail.com","Miguel Chisino","k+jijKQL/TpgnJyANoZnUymCqy1AoHO0ybqHn6ZV0Zve6i3tIk6YvZzMqYw9RZCE ","");

insert into cliente_telefono values ("1005278617","3016976242");
insert into cliente_telefono values ("1005278619","3016976243");
insert into cliente_telefono values ("1005278613","3016976244");
insert into cliente_telefono values ("1005278612","3016976245");
insert into cliente_telefono values ("1005278617","3016976233");

insert into confiteria values(1,"Sandich",2500,"");
insert into confiteria values(2,"Hamburguesa",5500,"");
insert into confiteria values(3,"Perro",6500,"");
insert into confiteria values(4,"Gaseosa",4000,"");
insert into confiteria values(5,"Crispetas",6000,"");

insert into cupon values (1,"Nuevo registro","Cada que una cliente se regsitre tendra acceso a este cupon","regist",15);
insert into cupon values (2,"Halloween","Se activa en el mes de octubre","HALLOWEEN",15);
insert into cupon values (3,"Año Nuevo","Se activa cada mes de diciembre","NEWYEAR",15);

insert into estacionamiento values (1,2500);
insert into estacionamiento values (2,2500);
insert into estacionamiento values (3,2500);
insert into estacionamiento values (4,2500);
insert into estacionamiento values (5,2500);

insert into pelicula values(1,"Pelicula de asentinato masivo en texas","Pre-Venta","Terror","Masacre Texas","https://res.cloudinary.com/ddcbwi9cw/image/upload/v1668271716/Unicine/1366_2000_ml7l8b.jpg","Un hombre trastornado empieza una maasacre","https://www.youtube.com/embed/mQPCg8-Qed8");
insert into pelicula values(2,"Pelicula sobre lluvia de comida","Estreno","Comedia","Lluvia de hamburguesas","https://res.cloudinary.com/ddcbwi9cw/image/upload/v1668271694/Unicine/2_yiy5mg.jpg","Un cientifico inventa un aparato que hace que llueva comida pero pierde el control","https://www.youtube.com/embed/Zsi015h_dgQ");
insert into pelicula values(3,"Pelicula sobre jugetes","Estreno","Infantil","Toy Story","https://res.cloudinary.com/ddcbwi9cw/image/upload/v1668271695/Unicine/3_rpi3oj.jpg","Los juguetes de Andy pueden hablar","https://www.youtube.com/embed/rNk1Wi8SvNc");
insert into pelicula values(4,"Pelicula sobre un pez perdido","En Transmision","Infantil","Buscando","https://res.cloudinary.com/ddcbwi9cw/image/upload/v1668271696/Unicine/4_gzvtzd.jpg","Nemo desaparece y su padre merlin tiene que buscarlo","https://www.youtube.com/embed/ba4TwyaNhSQ");
insert into pelicula values(5,"Pelicula sobre Thor el dios del trueno","En Trasmicion","Accion","Thor","https://res.cloudinary.com/ddcbwi9cw/image/upload/v1668271697/Unicine/5_hzbmxq.jpg","Thor regresa buscando venganza","https://www.youtube.com/embed/X4jhND5xfY4");

insert into teatro values(1,"Calle 13 local 2","Unicentro Cine",1);
insert into teatro values(2,"Avenida bolivar","Unicentro Cine",2);
insert into teatro values(3,"Carrera 13 calle 2","Unicentro Cine",3);
insert into teatro values(4,"Sergio Albroleda 12_13","Unicentro Cine",4);
insert into teatro values(5,"Distrito 2 calle 3 local 1","Unicentro Cine",5);

insert into Sala values (1,100,10,10,1);
insert into Sala values (2,100,10,10,1);
insert into Sala values (3,100,10,10,1);
insert into Sala values (4,100,10,10,1);
insert into Sala values (5,100,10,10,1);

insert into pelicula_sala values(1,1,1);
insert into pelicula_sala values(2,2,2);
insert into pelicula_sala values(3,3,3);
insert into pelicula_sala values(4,4,4);
insert into pelicula_sala values(5,5,5);

insert into horario values (1,"2022-12-12","5:20","9:20",2500.0,1);
insert into horario values (2,"2022-12-12","5:20","9:20",2500.0,2);
insert into horario values (3,"2022-12-12","5:20","9:20",2500.0,3);
insert into horario values (4,"2022-12-12","5:20","9:20",2500.0,4);
insert into horario values (5,"2022-12-12","5:20","9:20",2500.0,5);

