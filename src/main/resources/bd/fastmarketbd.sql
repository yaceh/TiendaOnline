Create database fastmarketbd;

use fastmarketbd;
create table marca(
idmarca int(11) not null auto_increment,
nombre varchar(30) default null,
constraint pk_marca primary key (idmarca)
);

insert into marca values (1,'costeño'),(2,'caserita'),(3,'primor'),(4,'Sin marca');

create table categoria(
idcategoria int(11) not null auto_increment,
nombre varchar(30) default null,
estado int(11) default null,
parentid int(11) default null,
constraint pk_categoria primary key (idcategoria)
);


insert into categoria values (1,'Frutas',1,0),(2,'Verduras',1,0),(3,'Abarrotes',1,0),(4,'Carnes y Embutidos',1,0),(5,'Bebidas y Licores',1,0),(6,'Otros',1,0),
(22,'Frutas',1,1),
(7,'Manzanas',1,22),(8,'Platanos',1,22),(9,'Naranjas',1,22),(10,'Mangos',1,22),

(23,'Tuberculos',1,2),
(11,'Papas',1,23),(12,'Camotes',1,23),(13,'cebollas',1,23),



(14,'Lacteos',1,3),(15,'Menestras',1,3),(16,'Aceites',1,3),(17,'Bebidas',1,3),
(18,'Leche',1,14),(19,'Yogurt',1,14),(20,'Mantequilla',1,14),(21,'Quesos',1,14),
(24,'Arroz a granel',1,15),(25,'Arroz envasado',1,15),(26,'Menestras a granel',1,15),(27,'Menestras envasadas',1,15),
(28,'Aceite vegetal',1,16),(29,'Aceite de oliva',1,16),(30,'Otros aceites',1,16),
(31,'Agua',1,17),(32,'Energizantes',1,17),(33,'Gaseosas',1,17),(34,'Jugos y refrescos',1,17),

(35,'Carne',1,4),(36,'Conservas',1,4),(37,'Pescado',1,4),(38,'Embutidos',1,4),
(39,'Pollo',1,35),(40,'Pavo',1,35),(41,'Cerdo',1,35),(42,'Res',1,35),

(43,'Cerveza',1,5),(44,'Pisco',1,5),(45,'Ron',1,5),(46,'Whiskys',1,5),
(47,'Cristal',1,43),(48,'Pilsen',1,43),(49,'Cusqueña',1,43),(50,'Corona',1,43),

(51,'Dulces',1,6),(52,'Galletas',1,6),(53,'Pastas',1,6),(54,'condimentos',1,6),
(55,'chocolates',1,51),(56,'galletas',1,51),(57,'helados',1,51),(58,'caramelos',1,51);




DROP TABLE IF EXISTS `partner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partner` (
  `idpartner` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idpartner`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partner`
--

LOCK TABLES `partner` WRITE;
/*!40000 ALTER TABLE `partner` DISABLE KEYS */;
INSERT INTO `partner` VALUES (1,'partner A'),(2,'partner B'),(3,'partner C');
/*!40000 ALTER TABLE `partner` ENABLE KEYS */;
UNLOCK TABLES;

create table producto(
idproducto int(11) not null auto_increment,
nombre varchar(40) not null,
precio decimal(18,2) not null,
cantidad int(11) not null,
descripcion varchar(500) default null,
urlimagen varchar(100) default null,
caracteristicas tinyint(4) not null,
idcategoria int (11) not null,
idpartner int(11) not null,
idmarca int(11) not null,
feature tinyint(4) ,
constraint pk_producto primary key (idproducto) ,
constraint fk_producto_partner foreign key(idpartner) references partner(idpartner) ON DELETE NO ACTION ON UPDATE NO ACTION,
constraint fk_prodcuto_categoria foreign key(idcategoria) references categoria(idcategoria) ON DELETE NO ACTION ON UPDATE NO ACTION,
constraint fk_producto_marca foreign key(idmarca) references marca(idmarca) ON DELETE NO ACTION ON UPDATE NO ACTION
);


INSERT INTO `producto` (`idproducto`,`nombre`,`precio`,`cantidad`,`descripcion`,`urlimagen`,`caracteristicas`,`idcategoria`,`idpartner`,`idmarca`,`feature`) VALUES (1,'Manzana Fuji',4.00,100,'manzana fuji fresca','manzanafuji.jpg',1,7,1,4,1);
INSERT INTO `producto` (`idproducto`,`nombre`,`precio`,`cantidad`,`descripcion`,`urlimagen`,`caracteristicas`,`idcategoria`,`idpartner`,`idmarca`,`feature`) VALUES (2,'Manzana Royal',4.00,100,'manzana royal fresca','manzanaroyal.jpg',1,7,1,4,1);
INSERT INTO `producto` (`idproducto`,`nombre`,`precio`,`cantidad`,`descripcion`,`urlimagen`,`caracteristicas`,`idcategoria`,`idpartner`,`idmarca`,`feature`) VALUES (3,'Manzana Pink Lady',5.00,100,'manzana pink lady fresca','manzanpinklady.jpg',1,7,1,4,1);
INSERT INTO `producto` (`idproducto`,`nombre`,`precio`,`cantidad`,`descripcion`,`urlimagen`,`caracteristicas`,`idcategoria`,`idpartner`,`idmarca`,`feature`) VALUES (4,'Manzana Granny Smith',5.00,100,'manzana granny smith','manzanagrannysmith.jpg',1,7,1,4,1);
INSERT INTO `producto` (`idproducto`,`nombre`,`precio`,`cantidad`,`descripcion`,`urlimagen`,`caracteristicas`,`idcategoria`,`idpartner`,`idmarca`,`feature`) VALUES (5,'Platano Seda',3.00,100,'platano seda fresco','seda.jpg',1,8,1,4,1);
INSERT INTO `producto` (`idproducto`,`nombre`,`precio`,`cantidad`,`descripcion`,`urlimagen`,`caracteristicas`,`idcategoria`,`idpartner`,`idmarca`,`feature`) VALUES (6,'Platano Morado',4.00,100,'platano morado fresco','rojo.jpg',1,8,1,4,1);
INSERT INTO `producto` (`idproducto`,`nombre`,`precio`,`cantidad`,`descripcion`,`urlimagen`,`caracteristicas`,`idcategoria`,`idpartner`,`idmarca`,`feature`) VALUES (7,'Platano Isla',5.00,100,'platano isla fresco','isla.jpg',1,8,1,4,1);
INSERT INTO `producto` (`idproducto`,`nombre`,`precio`,`cantidad`,`descripcion`,`urlimagen`,`caracteristicas`,`idcategoria`,`idpartner`,`idmarca`,`feature`) VALUES (8,'Platano Macho',4.00,100,'platano macho fresco','macho.jpg',1,8,1,4,1);
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('9', 'Mango Manila', '6.00', '100', 'Manila mango fresco y de un agradable color amarillo', 'manila.jpg', '1', '10', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('10', 'Mango Kent', '7.00', '100', 'Mango Kent, mango rojo y amarillo de sabor dulce', 'kent.jpg', '1', '10', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('11', 'Mango Champagne', '8.00', '100', 'Mango champagne mango de sabor agridulce', 'champagne.jpg', '1', '10', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('12', 'Papa Blanca', '1.50', '100', 'Papa blanca exclusiva para pures y entradas', 'papablanca.jpg', '1', '11', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('13', 'Papa Amarilla', '2.00', '100', 'Papa amarilla, papa serranita, sabor delicioso y harinoso', 'papaamarilla.jpg', '1', '11', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('14', 'Papa Colorada o Rosa', '1.80', '100', 'Papa colorada, el mejor para frituras de gran sabor', 'paparosa.jpg', '1', '11', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('15', 'Camote', '2.00', '100', 'El perfecto sustituto para la papa y rico con ceviche', 'camote.png', '1', '12', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('16', 'Cebolla', '1.70', '100', 'No llores, porque hara deliciosas tus comudas', 'cebolla.jpg', '1', '13', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('17', 'Leche Gloria', '3.20', '100', 'Perfecto suplemento para los más pequeños del hogar', 'leche.jpg', '1', '18', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('18', 'Mantequilla Gloria', '1.20', '100', 'Que tu pan no se quede solo', 'mantequilla.png', '1', '20', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('19', 'Yogurt Gloria', '5.50', '100', 'Acompañante perfecto en un desayuno nutritivo', 'yogurt.jpg', '1', '19', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('20', 'Quese crema Gloria', '3.00', '100', 'Queso del campo a tu mesa', 'queso.jpg', '1', '21', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('21', 'Leche pura vida', '2.70', '100', 'Leche economica', 'Puravida.jpg', '1', '18', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('22', 'Leche Bonle', '3.00', '100', 'cremosa y deliciosa ', 'Bonle.jpg', '1', '18', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('23', 'Manteguilla manty', '4.50', '100', 'Facil de hurtar ', 'manty.jpg', '1', '20', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('24', 'Sello de oro ', '2.70', '100', 'delicioso y economico ', 'sellodeoro.jpg', '1', '20', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('25', 'Mantequilla Laive', '2.50', '100', 'contiene sal', 'laive.jpg', '1', '20', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('26', 'pollo san fernando ', '10.50', '12', 'pollo envolsado', '205375.jpg', '1', '39', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('27', 'Hambuergesa san Fernando', '5.40', '50', 'Listo para freir ', 'Hambuergesa.jpg', '1', '39', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('28 ', 'Nugget San fernando ', '4.90', '10', 'Listo para para el sarten', 'nugget.jpg', '1', '39', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('29', 'Enrollado de pollo ', '5.30', '40', 'delicioso ', 'enrollado.jpg', '1', '39', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('30', 'Yogurt Laive', '4.90', '50', 'Con muchas proteinas', 'yolaive.jpg', '1', '19', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('31', 'Yogurt Laive Bio', '5.10', '30', 'sabor a durazno', 'laivebio.jpg', '1', '19', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('32', 'Yogurt Laive Natural', '5.50', '50', 'rica y sabrosa', 'laivenatural.jpg', '1', '19', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('33', 'Yogurt Gloria', '4.80', '50', 'Sabor a fresa', 'gloriafresa.jpg', '1', '19', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('34', 'Queso Laive Mozzarella', '7.80', '15', 'queso', 'quesolaive.jpg', '1', '21', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('35', 'Queso Bonle', '7.45', '10', 'queso', 'quesobonle.jpg', '1', '21', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('36', 'Queso Parmesano', '15.20', '5', 'queso parmesano', 'quesoparmesanobonle.jpg', '1', '21', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('37', 'Queso Parmesano Laive', '15.50', '10', 'queso parmesano', 'quesoparmesanolaive.jpg', '1', '21', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('38', 'Arroz Costeño', '6.60', '15', 'Arroz blanco', 'costeno.jpg', '1', '24', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('39', 'Arroz La Siembra', '25.60', '4', 'Arroz de 5 kg', 'lasiembrajpg.jpg', '1', '24', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('40', 'Arroz Pacasmayo', '26.40', '10', 'Arroz de 5 kg', 'pacasmayo.jpg', '1', '24', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('41', 'Arroz Faraon', '4.50', '9', 'Arroz de 750 g', 'faraon.jpg', '1', '24', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('42', 'Alverjita verde', '3.60', '40', 'Menestra alverjita verde costeno', 'alverjitaverde.jpg', '1', '27', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('43', 'Frejor Panamito', '5.00', '10', 'Panamito', 'panamito.jpg', '1', '27', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('44', 'Pallar El Plebeyo ', '4.50', '48', 'pallar', 'pallar.jpg', '1', '27', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('45', 'Frijol Hoja Redonda', '3.80', '40', 'Frijol canario 500 g', 'canario.jpg', '1', '27', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('46', 'Trigo Rompe olla', '2.50', '47', 'Trigo 450 g', 'trigo.jpg', '1', '27', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('47', 'Lentejas Rompe olla', '3.10', '50', 'Lenteja 450 g', 'lenteja.jpg', '1', '27', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('48', 'Lenteja Costeño', '3.50', '50', 'Lenteja costeño 500 g', 'lentejacosteno.jpg', '1', '27', '1', '4', '1');
INSERT INTO `fastmarketbd`.`producto` (`idproducto`, `nombre`, `precio`, `cantidad`, `descripcion`, `urlimagen`, `caracteristicas`, `idcategoria`, `idpartner`, `idmarca`, `feature`) VALUES ('49', 'Alverjita verde Costeño', '3.00 ', '50', 'Alverjita verde costeño de 500 g', 'alverjacosteno.jpg', '1', '27', '1', '4', '1');
