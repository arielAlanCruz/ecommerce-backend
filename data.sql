
  
-- El ID 1 será el "Vendedor" dueño de los paquetes.
-- El ID 2 será el "Comprador" que usa tu carrito.
INSERT INTO usuario (email, nombre, activo) VALUES ('agencia@turismo.com', 'Agencia Vendedora', TRUE);
INSERT INTO usuario (email, nombre, activo) VALUES ('cliente@viajero.com', 'Turista Comprador', TRUE);

-- ---------------------------------------------------------
-- 2.2 CARGA DE CATEGORÍAS
-- ---------------------------------------------------------
INSERT INTO categoria (nombre, descripcion) VALUES ('Europa Clásica', 'Circuitos tradicionales y capitales europeas');
INSERT INTO categoria (nombre, descripcion) VALUES ('Caribe y Playas', 'All inclusive y destinos de playa internacionales');
INSERT INTO categoria (nombre, descripcion) VALUES ('Norteamérica', 'Compras, parques temáticos y ciudades de USA');
INSERT INTO categoria (nombre, descripcion) VALUES ('Patagonia y Sur', 'Paisajes fríos, glaciares y fin del mundo');
INSERT INTO categoria (nombre, descripcion) VALUES ('Escapadas Nacionales', 'Destinos cortos y clásicos dentro de Argentina');

-- ---------------------------------------------------------
-- 2.3 CARGA DE PAQUETES TURÍSTICOS  
-- ---------------------------------------------------------

  
INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 1, 'Camino de Santiago Francés', 'Recorrido desde Sarria hasta Santiago de Compostela. 7 noches con alojamiento y credencial.', 1200.00, 20, '2026-10-15', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 1, 'Madrid, Andalucía y Toledo', 'Circuito de 9 días recorriendo Madrid, Sevilla, Córdoba, Granada y la Costa del Sol. Incluye AVE.', 2450.00, 30, '2026-10-22', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 1, 'Italia Clásica: Roma, Florencia y Venecia', 'Circuito de 10 días por las joyas de Italia. Incluye trenes de alta velocidad y guías locales.', 2800.00, 25, '2027-04-10', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 1, 'Capitales Imperiales', 'Praga, Viena y Budapest en 8 días. Vuelos y traslados internos incluidos.', 2150.00, 15, '2027-05-05', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 2, 'Río de Janeiro y Búzios', 'Paquete de 7 noches. Vuelos directos, traslados y alojamiento con desayuno.', 850.00, 50, '2026-11-01', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 2, 'Cancún All Inclusive Resort', '7 noches en hotel 5 estrellas frente al mar con sistema todo incluido.', 1550.00, 40, '2026-11-20', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 2, 'Punta Cana Relax', '8 días de puro sol en República Dominicana. Todo incluido y asistencia al viajero.', 1420.00, 45, '2026-11-25', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 2, 'Playa del Carmen y Tulum', '6 noches de alojamiento, visita a ruinas mayas y cenotes. Vuelos vía Copa Airlines.', 1300.00, 30, '2026-12-10', TRUE);

 
INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 3, 'Magia en Disney Orlando', '10 días. Incluye pases Park Hopper para 4 días en Disney y 2 en Universal Studios.', 2300.00, 60, '2026-12-05', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 3, 'Miami Beach y Compras', '7 días. Alojamiento en South Beach y traslados al Dolphin Mall y Sawgrass Mills.', 1250.00, 50, '2026-11-15', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 3, 'Nueva York: Manhattan Clásico', '6 noches en pleno Times Square, paseos por Central Park y Estatua de la Libertad.', 1950.00, 25, '2026-12-28', TRUE);
 
INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 4, 'Glaciar Perito Moreno (El Calafate)', '4 días y 3 noches. Excursión a las pasarelas y navegación Safari Náutico.', 480.00, 40, '2026-10-10', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 4, 'Ushuaia: Fin del Mundo', '5 días. Navegación por el Canal Beagle y excursión al Parque Nacional Tierra del Fuego.', 520.00, 35, '2026-11-05', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 4, 'Bariloche y Ruta de los 7 Lagos', '7 días. Circuito Chico, Cerro Catedral y excursión de día entero a San Martín de los Andes.', 600.00, 50, '2027-01-15', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 4, 'Puerto Madryn: Avistaje de Ballenas', '4 días. Incluye excursión a Península Valdés y avistaje embarcado tradicional.', 450.00, 30, '2026-10-30', TRUE);
 
INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 5, 'Cataratas del Iguazú', '4 días. Excursiones al lado Argentino y Brasileño. Vuelos directos.', 320.00, 60, '2026-10-20', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 5, 'Mendoza: Ruta del Vino', '4 días. Alojamiento en el centro, visita a dos bodegas con degustación y almuerzo.', 390.00, 40, '2026-11-15', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 5, 'City Tour CABA y Tango', 'Fin de semana en Buenos Aires. Recorrido por Obelisco, Caminito, San Telmo y cena show de Tango.', 180.00, 50, '2026-10-10', TRUE);

INSERT INTO producto (vendedor_id, categoria_id, nombre, descripcion, precio, stock, fecha_salida, activo) 
VALUES (1, 5, 'Termas de Federación', '3 noches de relax en Entre Ríos con acceso libre al parque termal.', 150.00, 40, '2026-10-25', TRUE);

-- ---------------------------------------------------------
-- 2.4 CARGA DE IMÁGENES ( muestra para testear)
-- ---------------------------------------------------------

INSERT INTO imagen_producto (producto_id, url, orden) VALUES (1, 'https://images.unsplash.com/photo-1553509230-0eb2c2e08e62?w=800', 1);
INSERT INTO imagen_producto (producto_id, url, orden) VALUES (2, 'https://images.unsplash.com/photo-1539037116277-4db20202d03e?w=800', 1);
INSERT INTO imagen_producto (producto_id, url, orden) VALUES (3, 'https://images.unsplash.com/photo-1552832230-c0197dd311b5?w=800', 1);
INSERT INTO imagen_producto (producto_id, url, orden) VALUES (5, 'https://images.unsplash.com/photo-1483729558449-99ef09a8c325?w=800', 1);
INSERT INTO imagen_producto (producto_id, url, orden) VALUES (6, 'https://images.unsplash.com/photo-1552074284-5e88ef1aef18?w=800', 1);
INSERT INTO imagen_producto (producto_id, url, orden) VALUES (9, 'https://images.unsplash.com/photo-1605806616949-1e87b487cb2a?w=800', 1);
INSERT INTO imagen_producto (producto_id, url, orden) VALUES (12, 'https://images.unsplash.com/photo-1589552174304-4bbaaa3d395a?w=800', 1);
INSERT INTO imagen_producto (producto_id, url, orden) VALUES (18, 'https://images.unsplash.com/photo-1613328224641-79b8a8047915?w=800', 1);
select * from categoria;
select * from producto;
select * from usuario;
select * from imagen_producto;
select * from carrito;
select * from item_carrito;


