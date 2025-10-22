import mysql.connector

class ConexionDB:   

    def conectar(self):
        self.conexion =mysql.connector.connect(host="localhost", user="root", passwd="", database="proyectopython")
        return self.conexion

    #OBTENER TODOS ITEMS DEL ESTADO POR EMPEZAR
    def todosExamenesProyectoPorEmpezar(self,tipo):
        cone=self.conectar()
        cursor=cone.cursor()
        dato = (tipo,)
        sql=("SELECT id, fecha, hora, calificacion, asignatura FROM tareas_evaluables WHERE estado='POR_EMPEZAR' AND tipo=%s")
        cursor.execute(sql,dato)
        cone.close()
        return cursor.fetchall()
    
    def todosTareasPorEmpezar(self):
        cone=self.conectar()
        cursor=cone.cursor()
        sql=("SELECT id, fecha, hora, titulo, descripcion FROM tareas WHERE estado='POR_EMPEZAR'")
        cursor.execute(sql)
        cone.close()
        return cursor.fetchall()

    #OBTENER TODOS ITEMS DEL ESTADO EN PROCESO
    def todosExamenesProyectoEnProceso(self,tipo):
        cone=self.conectar()
        cursor=cone.cursor()
        dato = (tipo,)
        sql=("SELECT id, fecha, hora, calificacion, asignatura FROM tareas_evaluables WHERE estado='EN_PROCESO' AND tipo=%s")
        cursor.execute(sql,dato)
        cone.close()
        return cursor.fetchall()
    
    def todosTareasEnProceso(self):
        cone=self.conectar()
        cursor=cone.cursor()
        sql=("SELECT id, fecha, hora, titulo, descripcion FROM tareas WHERE estado='EN_PROCESO'")
        cursor.execute(sql)
        cone.close()
        return cursor.fetchall()

    #OBTENER TODOS ITEMS DEL ESTADO FINALIZADO
    def todosExamenesProyectoFinalizado(self,tipo):
        cone=self.conectar()
        cursor=cone.cursor()
        dato = (tipo,)
        sql=("SELECT id, fecha, hora, calificacion, asignatura FROM tareas_evaluables WHERE estado='FINALIZADO' AND tipo=%s")
        cursor.execute(sql,dato)
        cone.close()
        return cursor.fetchall()
    
    
    def todosTareasFinalizado(self):
        cone=self.conectar()
        cursor=cone.cursor()
        sql=("SELECT id, fecha, hora, titulo, descripcion FROM tareas WHERE estado='FINALIZADO'")
        cursor.execute(sql)
        cone.close()
        return cursor.fetchall()
    
    #AÑADIR UN EXAMEN O PROYECTO A BASE DE DATOS
    def anadirExamenProyecto(self,fecha,hora,asignatura,tipo):
        flag=False
        cone=self.conectar()
        cursor=cone.cursor()
        datos=(fecha,hora,0,asignatura,tipo,"POR_EMPEZAR")
        sql=("INSERT INTO tareas_evaluables(fecha,hora,calificacion,asignatura,tipo,estado) VALUE (%s,%s,%s,%s,%s,%s)")
        cursor.execute(sql,datos)
        cone.commit()
        cone.close()
        if cursor.rowcount == 1:
            flag=True
            return flag
        else:
            return flag
    
    def anadirTarea(self,fecha,hora,titulo,descripcion):
        flag=False
        cone=self.conectar()
        cursor=cone.cursor()
        datos=(fecha,hora,titulo,descripcion,"POR_EMPEZAR")
        sql=("INSERT INTO tareas(fecha,hora,titulo,descripcion,estado) VALUE (%s,%s,%s,%s,%s)")
        cursor.execute(sql,datos)
        cone.commit()
        cone.close()
        if cursor.rowcount == 1:
            flag=True
            return flag
        else:
            return flag
    
    #AÑADIR CALIFICACION
    def anadirCalificacion(self,calificacion,id):
        flag=False
        cone=self.conectar()
        cursor=cone.cursor()
        datos=(calificacion,id)
        sql=("UPDATE tareas_evaluables SET calificacion=%s WHERE id=%s")
        cursor.execute(sql,datos)
        cone.commit()
        cone.close()
        if cursor.rowcount == 1:
            flag=True
            return flag
        else:
            return flag

    #MODIFICAR EXAMEN O PROYECTO
    def modificarExamenProyecto(self,fecha,hora,calificacion,asignatura,id):
        flag = False
        cone=self.conectar()
        cursor=cone.cursor()
        datos=(fecha,hora,calificacion,asignatura,id)
        sql=("UPDATE tareas_evaluables SET fecha=%s, hora=%s, calificacion=%s, asignatura=%s WHERE id=%s")
        cursor.execute(sql,datos)
        cone.commit()
        cone.close()
        if cursor.rowcount == 1:
            flag=True
            return flag
        else:
            return flag
    
    #MODIFICAR TAREA
    def modificarTarea(self,fecha,hora,titulo,descripcion,id):
        flag=False
        cone=self.conectar()
        cursor=cone.cursor()
        datos=(fecha,hora,titulo,descripcion,id)
        sql=("UPDATE tareas SET fecha=%s, hora=%s, titulo=%s, descripcion=%s WHERE id=%s")
        cursor.execute(sql,datos)
        cone.commit()
        cone.close()
        if cursor.rowcount == 1:
            flag=True
            return flag
        else:
            return flag
    
    #CAMBIAR ESTADO EXAMEN O PROYECTO
    def cambioDeEstadoEP(self,estado,id):
        flag=False
        cone=self.conectar()
        cursor=cone.cursor()
        datos=(estado,id)
        sql=("UPDATE tareas_evaluables SET estado=%s WHERE id=%s")
        cursor.execute(sql,datos)
        cone.commit()
        cone.close()
        if cursor.rowcount == 1:
            flag=True
            return flag
        else:
            return flag
    
    #CAMBIAR ESTADO TAREA
    def cambioDeEstadoT(self,estado,id):
        flag=False
        cone=self.conectar()
        cursor=cone.cursor()
        datos=(estado,id)
        sql=("UPDATE tareas SET estado=%s WHERE id=%s")
        cursor.execute(sql,datos)
        cone.commit()
        cone.close()
        if cursor.rowcount == 1:
            flag=True
            return flag
        else:
            return flag

