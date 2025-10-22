
import tkinter as tk 
from tkinter import ttk
from tkinter import messagebox as mb
from tkinter import scrolledtext as st

import ConexionDataBase

#PANELES
class VentanaLogin():
    def __init__(self):
        self.db=ConexionDataBase.ConexionDB()
        self.ventanaPrincipal()
        

    #VENTANA PRINCIPAL
    def ventanaPrincipal(self):
        self.ventana=tk.Tk()
        menuBar = tk.Menu(self.ventana)
        self.ventana.config(menu=menuBar)
        opciones1 = tk.Menu(menuBar)
        menuBar.add_command(label="Inicio",command=self.inicio)
        opciones1.add_command(label="Añadir examen",command=self.anadirExamen)
        opciones1.add_command(label="Añadir calificación",command=self.anadirCalificacionExamen)
        opciones1.add_command(label="Modificar examen",command=self.modificarExamen)
        opciones1.add_command(label="Cambiar estado",command=self.cambiarEstadoE)
        menuBar.add_cascade(label="Gestión examen",menu=opciones1)
        opciones2 = tk.Menu(menuBar)
        opciones2.add_command(label="Añadir proyecto",command=self.anadirProyecto)
        opciones2.add_command(label="Añadir calificación",command=self.anadirCalificacionProyecto)
        opciones2.add_command(label="Modificar proyecto",command=self.modificarProyecto)
        opciones2.add_command(label="Cambiar estado",command=self.cambiarEstadoP)
        menuBar.add_cascade(label="Gestión proyecto",menu=opciones2)
        opciones3 = tk.Menu(menuBar)
        opciones3.add_command(label="Añadir tarea",command=self.anadirTarea)
        opciones3.add_command(label="Modificar tarea",command=self.modificarTarea)
        opciones3.add_command(label="Cambiar estado",command=self.cambiarEstadoT)
        menuBar.add_cascade(label="Gestión tarea",menu=opciones3)
        self.inicio()
        self.ventana.mainloop()

    


    def inicio(self):
        self.frameInicio = tk.Frame(self.ventana,background="silver")
        self.frameInicio.grid(column=0,row=0,sticky="nsew")
        self.frameInicio.columnconfigure(0,weight=1)
        self.frameInicio.columnconfigure(1,weight=1)
        self.frameInicio.columnconfigure(2,weight=1)

        self.label1 = tk.Label(self.frameInicio, text="Por empezar", background="salmon")
        self.label1.grid(column=0,row=0,sticky="nsew")
        self.label1 = tk.Label(self.frameInicio, text="En proceso", background="sky blue")
        self.label1.grid(column=1,row=0,sticky="nsew")
        self.label1 = tk.Label(self.frameInicio, text="Finalizados", background="lightgreen")
        self.label1.grid(column=2,row=0,sticky="nsew")

        self.scrolledtext1=st.ScrolledText(self.frameInicio,width=30,height=10)
        self.scrolledtext1.grid(column=0, row=1, padx=10, pady=10)
        self.listarPorEmpezar()

        self.scrolledtext2=st.ScrolledText(self.frameInicio,width=30,height=10)
        self.scrolledtext2.grid(column=1, row=1, padx=10, pady=10)
        self.listarEnProceso()

        self.scrolledtext3=st.ScrolledText(self.frameInicio,width=30,height=10)
        self.scrolledtext3.grid(column=2, row=1, padx=10, pady=10)
        self.listarFinalizado()

    #CARGAR LAS LISTAS DE CADA ESTADO 
    def listarPorEmpezar(self):
        examenes=self.db.todosExamenesProyectoPorEmpezar("examen")
        self.scrolledtext1.delete("1.0", tk.END)
        for e in examenes:
            self.scrolledtext1.insert(tk.END, "Examen--------------------\nid:"+str(e[0])+"\nfecha:"+str(e[1])+"\nhora:"+str(e[2])+"\ncalificación:"+str(e[3])+"\nasignatura:"+str(e[4])+"\n--------------------------\n")
        
        proyectos=self.db.todosExamenesProyectoPorEmpezar("proyecto")
        for p in proyectos:
            self.scrolledtext1.insert(tk.END,"Proyecto------------------\nid:"+str(p[0])+"\nfecha:"+str(p[1])+"\nhora:"+str(p[2])+"\ncalificación:"+str(p[3])+"\nasignatura:"+str(p[4])+"\n--------------------------\n") 
        
        tareas=self.db.todosTareasPorEmpezar()
        for t in tareas:
            self.scrolledtext1.insert(tk.END,"Tarea---------------------\nid:"+str(t[0])+"\nfecha:"+str(t[1])+"\nhora:"+str(t[2])+"\ntítulo:"+str(t[3])+"\ndescripción:"+str(t[4])+"\n--------------------------\n") 

    def listarEnProceso(self):
        examenes=self.db.todosExamenesProyectoEnProceso("examen")
        self.scrolledtext2.delete("1.0", tk.END)
        for e in examenes:
            self.scrolledtext2.insert(tk.END, "Examen--------------------\nid:"+str(e[0])+"\nfecha:"+str(e[1])+"\nhora:"+str(e[2])+"\ncalificación:"+str(e[3])+"\nasignatura:"+str(e[4])+"\n--------------------------\n")
        
        proyectos=self.db.todosExamenesProyectoEnProceso("proyecto")
        for p in proyectos:
            self.scrolledtext2.insert(tk.END,"Proyecto------------------\nid:"+str(p[0])+"\nfecha:"+str(p[1])+"\nhora:"+str(p[2])+"\ncalificación:"+str(p[3])+"\nasignatura:"+str(p[4])+"\n--------------------------\n") 
        
        tareas=self.db.todosTareasEnProceso()
        for t in tareas:
            self.scrolledtext2.insert(tk.END,"Tarea---------------------\nid:"+str(t[0])+"\nfecha:"+str(t[1])+"\nhora:"+str(t[2])+"\ntítulo:"+str(t[3])+"\ndescripción:"+str(t[4])+"\n--------------------------\n") 

    def listarFinalizado(self):
        examenes=self.db.todosExamenesProyectoFinalizado("examen")
        self.scrolledtext3.delete("1.0", tk.END)
        for e in examenes:
            self.scrolledtext3.insert(tk.END, "Examen--------------------\nid:"+str(e[0])+"\nfecha:"+str(e[1])+"\nhora:"+str(e[2])+"\ncalificación:"+str(e[3])+"\nasignatura:"+str(e[4])+"\n--------------------------\n")
        
        proyectos=self.db.todosExamenesProyectoFinalizado("proyecto")
        for p in proyectos:
            self.scrolledtext3.insert(tk.END,"Proyecto------------------\nid:"+str(p[0])+"\nfecha:"+str(p[1])+"\nhora:"+str(p[2])+"\ncalificación:"+str(p[3])+"\nasignatura:"+str(p[4])+"\n--------------------------\n") 
        
        tareas=self.db.todosTareasFinalizado()
        for t in tareas:
            self.scrolledtext3.insert(tk.END,"Tarea---------------------\nid:"+str(t[0])+"\nfecha:"+str(t[1])+"\nhora:"+str(t[2])+"\ntítulo:"+str(t[3])+"\ndescripción:"+str(t[4])+"\n--------------------------\n") 


    #AÑADIR EXAMENES
    def anadirExamen(self):
        self.anadirE = tk.Frame(self.ventana)
        self.anadirE.grid(column=0,row=0,sticky="nsew")
        self.anadirE.grid_columnconfigure(0, weight=1)
        self.anadirE.grid_columnconfigure(1, weight=1)
    
        self.ventana.grid_rowconfigure(0, weight=1)
        self.ventana.grid_columnconfigure(0, weight=1)

        self.dato1 = tk.StringVar()
        self.label1 = ttk.Label(self.anadirE, text="Introduce la fecha del examen: ")
        self.label1.grid(column=0, row=0, sticky="nsew", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.anadirE, width=20, textvariable=self.dato1)
        self.entry1.grid(column=1, row=0, sticky="nsew", padx=10, pady=5)
    
        self.dato2 = tk.StringVar()
        self.label2 = ttk.Label(self.anadirE, text="Introduce la hora del examen: ")
        self.label2.grid(column=0, row=1, sticky="nsew", padx=5, pady=5)
        self.entry2 = ttk.Entry(self.anadirE, width=20, textvariable=self.dato2)
        self.entry2.grid(column=1, row=1, sticky="nsew", padx=10, pady=5)

        self.dato3 = tk.StringVar()
        self.label3 = ttk.Label(self.anadirE, text="Introduce la asignatura del examen: ")
        self.label3.grid(column=0, row=2, sticky="nsew", padx=5, pady=5)
        self.entry3 = ttk.Entry(self.anadirE, width=20, textvariable=self.dato3)
        self.entry3.grid(column=1, row=2, sticky="nsew", padx=10, pady=5)

        self.botonEnviar=ttk.Button(self.anadirE,command=self.enviarExamen,text="Enviar")
        self.botonEnviar.grid(column=0,row=4,sticky="nsew",columnspan=2)
        self.botonBorrar=ttk.Button(self.anadirE,command=self.borrar,text="Borrar")
        self.botonBorrar.grid(column=0,row=5,sticky="nsew",columnspan=2)


        

    #AÑADIR CALIFICACION EXAMEN
    def anadirCalificacionExamen(self):
        self.anadirC = tk.Frame(self.ventana)
        self.anadirC.grid(column=0,row=0,sticky="nsew")
        self.anadirC.grid_columnconfigure(0, weight=1)
        self.anadirC.grid_columnconfigure(1, weight=1)
    
        self.ventana.grid_rowconfigure(0, weight=1)
        self.ventana.grid_columnconfigure(0, weight=1)

        self.dato1 = tk.StringVar()
        self.labelFrameM = ttk.LabelFrame(self.anadirC, text="ID")
        self.labelFrameM.grid(column=0, row=0, sticky="nsew", columnspan=2)
        self.label1=ttk.Label(self.labelFrameM,text="Introduce la id del examen: ")
        self.label1.grid(column=0,row=0,sticky="nsew", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.labelFrameM, width=3, textvariable=self.dato1)
        self.entry1.grid(column=1, row=0, sticky="nsew", padx=10, pady=5)
        self.labelFrameM.grid_columnconfigure(0, weight=1)
        self.labelFrameM.grid_columnconfigure(1, weight=1)

        self.dato2 = tk.StringVar()
        self.label2 = ttk.Label(self.anadirC, text="Introduce la calificación del examen: ")
        self.label2.grid(column=0, row=1, sticky="nsew", padx=5, pady=5)
        self.entry2 = ttk.Entry(self.anadirC, width=20, textvariable=self.dato2)
        self.entry2.grid(column=1, row=1, sticky="nsew", padx=10, pady=5)

        self.botonEnviar=ttk.Button(self.anadirC,command=self.enviarExamenCalificacion,text="Enviar")
        self.botonEnviar.grid(column=0,row=4,sticky="nsew",columnspan=2)
        self.botonBorrar=ttk.Button(self.anadirC,command=self.borrar,text="Borrar")
        self.botonBorrar.grid(column=0,row=5,sticky="nsew",columnspan=2)

       
    #ENVIAR EXAMEN CALIFICACION
    def enviarExamenCalificacion(self):
        if self.db.anadirCalificacion(self.dato2.get(),self.dato1.get()):
            mb.showinfo("Información", f"Se ha añadido correctamente la calificación del examen{self.dato1.get()}.")
        else:
            mb.showerror("Error","Ha habido un fallo al agregar la calificación.")

        #VACIA LOS CAMPOS
        self.entry1.delete(0,tk.END)
        self.entry2.delete(0,tk.END)
        self.entry3.delete(0,tk.END)
        self.entry4.delete(0,tk.END)

    #BOTON DE BORRAR
    def borrar(self):
        self.entry1.delete(0,tk.END)
        self.entry2.delete(0,tk.END)
        self.entry3.delete(0,tk.END)
        self.entry4.delete(0,tk.END)

    #BOTON DE AÑADIR UN EXAMEN 
    def enviarExamen(self):
        if self.db.anadirExamenProyecto(self.dato1.get(), self.dato2.get(),self.dato3.get(),"examen")==True:
            mb.showinfo("Información", "Se ha añadido correctamente el examen.")
        else:
            mb.showerror("Error","Ha habido un fallo al agregar el examen.")

        #VACIA LOS CAMPOS
        self.entry1.delete(0,tk.END)
        self.entry2.delete(0,tk.END)
        self.entry3.delete(0,tk.END)
       
    #MODIFICAR EXAMEN
    def modificarExamen(self):
        self.modifyE = tk.Frame(self.ventana)
        self.modifyE.grid(column=0,row=0,sticky="nsew")
        self.modifyE.grid_columnconfigure(0, weight=1)
        self.modifyE.grid_columnconfigure(1, weight=1)
    
        self.ventana.grid_rowconfigure(0, weight=1)
        self.ventana.grid_columnconfigure(0, weight=1)

        self.dato1 = tk.StringVar()
        self.labelFrameM = ttk.LabelFrame(self.modifyE, text="ID")
        self.labelFrameM.grid(column=0, row=0, sticky="nsew", columnspan=2)
        self.label1=ttk.Label(self.labelFrameM,text="Introduce la id del examen a modificar: ")
        self.label1.grid(column=0,row=0,sticky="nsew", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.labelFrameM, width=3, textvariable=self.dato1)
        self.entry1.grid(column=1, row=0, sticky="nsew", padx=10, pady=5)
        self.labelFrameM.grid_columnconfigure(0, weight=1)
        self.labelFrameM.grid_columnconfigure(1, weight=1)

        self.dato2 = tk.StringVar()
        self.label1 = ttk.Label(self.modifyE, text="Introduce la nueva fecha del examen que quiera modificar: ")
        self.label1.grid(column=0, row=1, sticky="w", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.modifyE, width=50, textvariable=self.dato2)
        self.entry1.grid(column=1, row=1, sticky="e", padx=10, pady=5)

        self.dato3 = tk.StringVar()
        self.label2 = ttk.Label(self.modifyE, text="Introduce la nueva hora del examen: ")
        self.label2.grid(column=0, row=2, sticky="w", padx=5, pady=5)
        self.entry2 = ttk.Entry(self.modifyE, width=50, textvariable=self.dato3)
        self.entry2.grid(column=1, row=2, sticky="e", padx=10, pady=5)

        self.dato4 = tk.StringVar()
        self.label3 = ttk.Label(self.modifyE, text="Introduce la nueva asignatura del examen: ")
        self.label3.grid(column=0, row=3, sticky="w", padx=5, pady=5)
        self.entry3 = ttk.Entry(self.modifyE, width=50, textvariable=self.dato4)
        self.entry3.grid(column=1, row=3, sticky="e", padx=10, pady=5)

        self.dato5 = tk.StringVar()
        self.label4 = ttk.Label(self.modifyE, text="Introduce la nueva calificación del examen: ")
        self.label4.grid(column=0, row=4, sticky="w", padx=1, pady=5)
        self.entry4 = ttk.Entry(self.modifyE, width=50, textvariable=self.dato5)
        self.entry4.grid(column=1, row=4, sticky="e", padx=10, pady=5)


        self.botonEnviar=ttk.Button(self.modifyE,command=self.enviarExamenModify,text="Enviar")
        self.botonEnviar.grid(column=0,row=5,sticky="nsew",columnspan=2)
        self.botonBorrar=ttk.Button(self.modifyE,command=self.borrar,text="Borrar")
        self.botonBorrar.grid(column=0,row=6,sticky="nsew",columnspan=2)

    #ENVIAR MODIFICAR EXAMEN
    def enviarExamenModify(self):
        if self.db.modificarExamenProyecto(self.dato2.get(),self.dato3.get(),self.dato5.get(),self.dato4.get(),self.dato1.get())==True:
            mb.showinfo("Información", "Se ha modificado correctamente el examen.")
        else:
            mb.showerror("Error","Ha habido un fallo al modificar el examen.")

        #VACIA LOS CAMPOS
        self.entry1.delete(0,tk.END)
        self.entry2.delete(0,tk.END)
        self.entry3.delete(0,tk.END)
        self.entry4.delete(0,tk.END)

    #CAMBIAR ESTADO AL EXAMEN
    def cambiarEstadoE(self):
        self.cambioE = tk.Frame(self.ventana)
        self.cambioE.grid(column=0,row=0,sticky="nsew")

        self.cambioE.grid_rowconfigure(0, weight=1)
        self.cambioE.grid_rowconfigure(1, weight=1)
        self.cambioE.grid_rowconfigure(2, weight=1)
        self.cambioE.grid_rowconfigure(3, weight=1)

        self.labelFrameE = tk.LabelFrame(self.cambioE,text="ID")
        self.labelFrameE.grid(column=0, row=1)

        self.dato1 = tk.StringVar()
        self.label1 = ttk.Label(self.labelFrameE, text="Introduce la id del examen: ")
        self.label1.grid(column=0, row=0, sticky="nsew")
        self.entry = ttk.Entry(self.labelFrameE, textvariable=self.dato1)
        self.entry.grid(column=1, row=0, sticky="nsew")


        self.seleccion=tk.IntVar()
        self.seleccion.set(1)
        self.radio1 = tk.Radiobutton(self.cambioE, variable=self.seleccion, value=1, text="Por empezar")
        self.radio1.grid(column=1, row=1,padx=50)
        self.radio2 = tk.Radiobutton(self.cambioE, variable=self.seleccion, value=2, text="En proceso")
        self.radio2.grid(column=2, row=1,padx=50)
        self.radio3 = tk.Radiobutton(self.cambioE, variable=self.seleccion, value=3, text="Finalizado")
        self.radio3.grid(column=3, row=1,padx=50)

        self.boton = ttk.Button(self.cambioE, text="Cambiar", command=self.cambioDeEstadoExamenProyecto)
        self.boton.grid(column=0,row=3,columnspan=4)
        
    #BOTON DE CAMBIO DE ESTADO PARA EXAMEN Y PROYECTO
    def cambioDeEstadoExamenProyecto(self):
        if self.seleccion.get()==1:
            if self.db.cambioDeEstadoEP("POR_EMPEZAR",self.dato1.get()):
                mb.showinfo("Info","Se ha cambiado de estado perfectamente")
            else:
                mb.showerror("Error","Ha habido un fallo al modificar el examen.")

        elif self.seleccion.get()==2:
            if self.db.cambioDeEstadoEP("EN_PROCESO",self.dato1.get()):
                mb.showinfo("Info","Se ha cambiado de estado perfectamente")
            else:
                mb.showerror("Error","Ha habido un fallo al modificar el examen.")

        elif self.seleccion.get()==3:
            if self.db.cambioDeEstadoEP("FINALIZADO",self.dato1.get()):
                mb.showinfo("Info","Se ha cambiado de estado perfectamente")
            else:
                mb.showerror("Error","Ha habido un fallo al modificar el examen.")

    #AÑADIR PROYECTOS
    def anadirProyecto(self):
        self.anadirP = tk.Frame(self.ventana)
        self.anadirP.grid(column=0,row=0,sticky="nsew")
    
        self.ventana.grid_rowconfigure(0, weight=1)
        self.ventana.grid_columnconfigure(0, weight=1)

        self.dato1 = tk.StringVar()
        self.label1 = ttk.Label(self.anadirP, text="Introduce la fecha del proyecto: ")
        self.label1.grid(column=0, row=0, sticky="nsew", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.anadirP, width=20, textvariable=self.dato1)
        self.entry1.grid(column=1, row=0, sticky="nsew", padx=10, pady=5)
    
        self.dato2 = tk.StringVar()
        self.label2 = ttk.Label(self.anadirP, text="Introduce la hora del proyecto: ")
        self.label2.grid(column=0, row=1, sticky="nsew", padx=5, pady=5)
        self.entry2 = ttk.Entry(self.anadirP, width=20, textvariable=self.dato2)
        self.entry2.grid(column=1, row=1, sticky="nsew", padx=10, pady=5)

        self.dato3 = tk.StringVar()
        self.label3 = ttk.Label(self.anadirP, text="Introduce la asignatura del proyecto: ")
        self.label3.grid(column=0, row=2, sticky="nsew", padx=5, pady=5)
        self.entry3 = ttk.Entry(self.anadirP, width=20, textvariable=self.dato3)
        self.entry3.grid(column=1, row=2, sticky="nsew", padx=10, pady=5)

        self.botonEnviar=ttk.Button(self.anadirP,command=self.enviarProyecto,text="Enviar")
        self.botonEnviar.grid(column=0,row=4,sticky="nsew",columnspan=2)
        self.botonBorrar=ttk.Button(self.anadirP,command=self.borrar,text="Borrar")
        self.botonBorrar.grid(column=0,row=5,sticky="nsew",columnspan=2)

        self.anadirP.grid_columnconfigure(0, weight=1)
        self.anadirP.grid_columnconfigure(1, weight=1)

    #ENVIAR AÑADIR PROYECTO
    def enviarProyecto(self):
        if self.db.anadirExamenProyecto(self.dato1.get(), self.dato2.get(),self.dato3.get(),"proyecto")==True:
            mb.showinfo("Información", "Se ha añadido correctamente el proyecto.")
        else:
            mb.showerror("Error","Ha habido un fallo al agregar el proyecto.")

        #VACIA LOS CAMPOS
        self.entry1.delete(0,tk.END)
        self.entry2.delete(0,tk.END)
        self.entry3.delete(0,tk.END)
        self.entry4.delete(0,tk.END)

    #AÑADIR CALIFICACION EXAMEN
    def anadirCalificacionProyecto(self):
        self.anadirCP = tk.Frame(self.ventana)
        self.anadirCP.grid(column=0,row=0,sticky="nsew")
        self.anadirCP.grid_columnconfigure(0, weight=1)
        self.anadirCP.grid_columnconfigure(1, weight=1)
    
        self.ventana.grid_rowconfigure(0, weight=1)
        self.ventana.grid_columnconfigure(0, weight=1)

        self.dato1 = tk.StringVar()
        self.labelFrameM = ttk.LabelFrame(self.anadirCP, text="ID")
        self.labelFrameM.grid(column=0, row=0, sticky="nsew", columnspan=2)
        self.label1=ttk.Label(self.labelFrameM,text="Introduce la id del proyecto: ")
        self.label1.grid(column=0,row=0,sticky="nsew", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.labelFrameM, width=3, textvariable=self.dato1)
        self.entry1.grid(column=1, row=0, sticky="nsew", padx=10, pady=5)
        self.labelFrameM.grid_columnconfigure(0, weight=1)
        self.labelFrameM.grid_columnconfigure(1, weight=1)

        self.dato2 = tk.StringVar()
        self.label2 = ttk.Label(self.anadirCP, text="Introduce la calificación del proyecto: ")
        self.label2.grid(column=0, row=1, sticky="nsew", padx=1, pady=5)
        self.entry2 = ttk.Entry(self.anadirCP, width=20, textvariable=self.dato2)
        self.entry2.grid(column=1, row=1, sticky="nsew", padx=10, pady=5)

        self.botonEnviar=ttk.Button(self.anadirCP,command=self.enviarProyectoCalificacion,text="Enviar")
        self.botonEnviar.grid(column=0,row=4,sticky="nsew",columnspan=2)
        self.botonBorrar=ttk.Button(self.anadirCP,command=self.borrar,text="Borrar")
        self.botonBorrar.grid(column=0,row=5,sticky="nsew",columnspan=2)
    
    #ENVIAR PROYECTO CALIFICACION
    def enviarProyectoCalificacion(self):
        if self.db.anadirCalificacion(self.dato2.get(),self.dato1.get()):
            mb.showinfo("Información", f"Se ha añadido correctamente la calificación del proyecto{self.dato1.get()}.")
        else:
            mb.showerror("Error","Ha habido un fallo al agregar la calificación.")

        #VACIA LOS CAMPOS
        self.entry1.delete(0,tk.END)
        self.entry2.delete(0,tk.END)
        self.entry3.delete(0,tk.END)
        self.entry4.delete(0,tk.END)

    #MODIFICAR PROYECTO
    def modificarProyecto(self):
        self.modifyP = tk.Frame(self.ventana)
        self.modifyP.grid(column=0,row=0,sticky="nsew")
        self.modifyP.grid_columnconfigure(0, weight=1)
        self.modifyP.grid_columnconfigure(1, weight=1)
    
        self.ventana.grid_rowconfigure(0, weight=1)
        self.ventana.grid_columnconfigure(0, weight=1)

        self.dato1 = tk.StringVar()
        self.labelFrameM = ttk.LabelFrame(self.modifyP, text="ID")
        self.labelFrameM.grid(column=0, row=0, sticky="nsew", columnspan=2)
        self.label1=ttk.Label(self.labelFrameM,text="Introduce la id del proyecto a modificar: ")
        self.label1.grid(column=0,row=0,sticky="nsew", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.labelFrameM, width=3, textvariable=self.dato1)
        self.entry1.grid(column=1, row=0, sticky="nsew", padx=10, pady=5)
        self.labelFrameM.grid_columnconfigure(0, weight=1)
        self.labelFrameM.grid_columnconfigure(1, weight=1)

        self.dato2 = tk.StringVar()
        self.label1 = ttk.Label(self.modifyP, text="Introduce la nueva fecha del proyecto que quiera modificar: ")
        self.label1.grid(column=0, row=1, sticky="w", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.modifyP, width=50, textvariable=self.dato2)
        self.entry1.grid(column=1, row=1, sticky="e", padx=10, pady=5)

        self.dato3 = tk.StringVar()
        self.label2 = ttk.Label(self.modifyP, text="Introduce la nueva hora del proyecto: ")
        self.label2.grid(column=0, row=2, sticky="w", padx=5, pady=5)
        self.entry2 = ttk.Entry(self.modifyP, width=50, textvariable=self.dato3)
        self.entry2.grid(column=1, row=2, sticky="e", padx=10, pady=5)

        self.dato4 = tk.StringVar()
        self.label3 = ttk.Label(self.modifyP, text="Introduce la nueva asignatura del proyecto: ")
        self.label3.grid(column=0, row=3, sticky="w", padx=5, pady=5)
        self.entry3 = ttk.Entry(self.modifyP, width=50, textvariable=self.dato4)
        self.entry3.grid(column=1, row=3, sticky="e", padx=10, pady=5)

        self.dato5 = tk.StringVar()
        self.label4 = ttk.Label(self.modifyP, text="Introduce la nueva calificación del proyecto: ")
        self.label4.grid(column=0, row=4, sticky="w", padx=1, pady=5)
        self.entry4 = ttk.Entry(self.modifyP, width=50, textvariable=self.dato5)
        self.entry4.grid(column=1, row=4, sticky="e", padx=10, pady=5)

        self.botonEnviar=ttk.Button(self.modifyP,command=self.enviarProyectonModify,text="Enviar")
        self.botonEnviar.grid(column=0,row=5,sticky="nsew",columnspan=2)
        self.botonBorrar=ttk.Button(self.modifyP,command=self.borrar,text="Borrar")
        self.botonBorrar.grid(column=0,row=6,sticky="nsew",columnspan=2)


    #ENVIAR MODIFICAR PROYECTO
    def enviarProyectonModify(self):
        if self.db.modificarExamenProyecto(self.dato2.get(),self.dato3.get(),self.dato5.get(),self.dato4.get(),self.dato1.get())==True:
            mb.showinfo("Información", "Se ha modificado correctamente el proyecto.")
        else:
            mb.showerror("Error","Ha habido un fallo al modificar el proyecto.")

        #VACIA LOS CAMPOS
        self.entry1.delete(0,tk.END)
        self.entry2.delete(0,tk.END)
        self.entry3.delete(0,tk.END)
        self.entry4.delete(0,tk.END)
    
    #CAMBIAR ESTADO AL PROYECTO
    def cambiarEstadoP(self):
        self.cambioP = tk.Frame(self.ventana)
        self.cambioP.grid(column=0,row=0,sticky="nsew")

        self.cambioP.grid_rowconfigure(0, weight=1)
        self.cambioP.grid_rowconfigure(1, weight=1)
        self.cambioP.grid_rowconfigure(2, weight=1)
        self.cambioP.grid_rowconfigure(3, weight=1)

        self.labelFrameE = tk.LabelFrame(self.cambioP,text="ID")
        self.labelFrameE.grid(column=0, row=1)

        self.dato1 = tk.StringVar()
        self.label1 = ttk.Label(self.labelFrameE, text="Introduce la id del proyecto: ")
        self.label1.grid(column=0, row=0, sticky="nsew")
        self.entry = ttk.Entry(self.labelFrameE, textvariable=self.dato1)
        self.entry.grid(column=1, row=0, sticky="nsew")


        self.seleccion=tk.IntVar()
        self.seleccion.set(1)
        self.radio1 = tk.Radiobutton(self.cambioP, variable=self.seleccion, value=1, text="Por empezar")
        self.radio1.grid(column=1, row=1,padx=50)
        self.radio2 = tk.Radiobutton(self.cambioP, variable=self.seleccion, value=2, text="En proceso")
        self.radio2.grid(column=2, row=1,padx=50)
        self.radio3 = tk.Radiobutton(self.cambioP, variable=self.seleccion, value=3, text="Finalizado")
        self.radio3.grid(column=3, row=1,padx=50)

        self.boton = ttk.Button(self.cambioP, text="Cambiar", command=self.cambioDeEstadoExamenProyecto)
        self.boton.grid(column=0,row=3,columnspan=4)
    

    #AÑADIR TAREAS
    def anadirTarea(self):
        self.anadirT = tk.Frame(self.ventana)
        self.anadirT.grid(column=0,row=0,sticky="nsew")
        self.anadirT.grid_columnconfigure(0, weight=1)
        self.anadirT.grid_columnconfigure(1, weight=1)

        self.ventana.grid_rowconfigure(0, weight=1)
        self.ventana.grid_columnconfigure(0, weight=1)

        self.dato1 = tk.StringVar()
        self.label1 = ttk.Label(self.anadirT, text="Introduce la fecha de la tarea: ")
        self.label1.grid(column=0, row=0, sticky="nsew", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.anadirT, width=20, textvariable=self.dato1)
        self.entry1.grid(column=1, row=0, sticky="nsew", padx=10, pady=5)
    
        self.dato2 = tk.StringVar()
        self.label2 = ttk.Label(self.anadirT, text="Introduce la hora de la tarea: ")
        self.label2.grid(column=0, row=1, sticky="nsew", padx=5, pady=5)
        self.entry2 = ttk.Entry(self.anadirT, width=20, textvariable=self.dato2)
        self.entry2.grid(column=1, row=1, sticky="nsew", padx=10, pady=5)

        self.dato3 = tk.StringVar()
        self.label3 = ttk.Label(self.anadirT, text="Introduce el titulo de la tarea: ")
        self.label3.grid(column=0, row=2, sticky="nsew", padx=5, pady=5)
        self.entry3 = ttk.Entry(self.anadirT, width=20, textvariable=self.dato3)
        self.entry3.grid(column=1, row=2, sticky="nsew", padx=10, pady=5)

        self.label4 = ttk.Label(self.anadirT, text="Introduce la descripción de la tarea: ")
        self.label4.grid(column=0, row=3, sticky="nsew", padx=1, pady=5)
        self.entry4 = st.ScrolledText(self.anadirT, width=20, height=3)
        self.entry4.grid(column=1, row=3,  sticky="nsew", padx=10, pady=5)
        self.dato4 = self.entry4.get("1.0", tk.END).strip()


        self.botonEnviar=ttk.Button(self.anadirT,command=self.enviarTarea,text="Enviar")
        self.botonEnviar.grid(column=0,row=4,sticky="nsew",columnspan=2)
        self.botonBorrar=ttk.Button(self.anadirT,command=self.borrar,text="Borrar")
        self.botonBorrar.grid(column=0,row=5,sticky="nsew",columnspan=2)

    #ENVIAR TAREA
    def enviarTarea(self):
        if self.db.anadirTarea(self.dato1.get(), self.dato2.get(),self.dato3.get(),self.dato4.get())==True:
            mb.showinfo("Información", "Se ha añadido correctamente la tarea.")
        else:
            mb.showerror("Error","Ha habido un fallo al agregar la tarea.")

        #VACIA LOS CAMPOS
        self.entry1.delete(0,tk.END)
        self.entry2.delete(0,tk.END)
        self.entry3.delete(0,tk.END)
        self.entry4.delete(0,tk.END)
        
    
    #MODIFICAR TAREA
    def modificarTarea(self):
        self.modifyT = tk.Frame(self.ventana)
        self.modifyT.grid(column=0,row=0,sticky="nsew")
        self.modifyT.grid_columnconfigure(0, weight=1)
        self.modifyT.grid_columnconfigure(1, weight=1)

        self.ventana.grid_rowconfigure(0, weight=1)
        self.ventana.grid_columnconfigure(0, weight=1)

        self.dato1 = tk.StringVar()
        self.labelFrameM = ttk.LabelFrame(self.modifyT, text="ID")
        self.labelFrameM.grid(column=0, row=0, sticky="nsew", columnspan=2)
        self.label1=ttk.Label(self.labelFrameM,text="Introduce la id de la tarea a modificar: ")
        self.label1.grid(column=0,row=0,sticky="nsew", padx=5, pady=5)
        self.entry1 = ttk.Entry(self.labelFrameM, width=3, textvariable=self.dato1)
        self.entry1.grid(column=1, row=0, sticky="nsew", padx=10, pady=5)
        self.labelFrameM.grid_columnconfigure(0, weight=1)
        self.labelFrameM.grid_columnconfigure(1, weight=1)

        self.dato2 = tk.StringVar()
        self.label2 = ttk.Label(self.modifyT, text="Introduce la nueva fecha de la tarea: ")
        self.label2.grid(column=0, row=1, sticky="w", padx=5, pady=5)
        self.entry2 = ttk.Entry(self.modifyT, width=50, textvariable=self.dato2)
        self.entry2.grid(column=1, row=1, sticky="e", padx=10, pady=5)

        self.dato3 = tk.StringVar()
        self.label3 = ttk.Label(self.modifyT, text="Introduce la nueva hora de la tarea: ")
        self.label3.grid(column=0, row=2, sticky="w", padx=5, pady=5)
        self.entry3 = ttk.Entry(self.modifyT, width=50, textvariable=self.dato3)
        self.entry3.grid(column=1, row=2, sticky="e", padx=10, pady=5)

        self.dato4 = tk.StringVar()
        self.label4 = ttk.Label(self.modifyT, text="Introduce el nuevo título de la tarea: ")
        self.label4.grid(column=0, row=3, sticky="w", padx=5, pady=5)
        self.entry4 = ttk.Entry(self.modifyT, width=50, textvariable=self.dato4)
        self.entry4.grid(column=1, row=3, sticky="e", padx=10, pady=5)

        self.label5 = ttk.Label(self.modifyT, text="Introduce la nueva descripción de la tarea: ")
        self.label5.grid(column=0, row=4, sticky="w", padx=1, pady=5)
        self.entry5 = st.ScrolledText(self.modifyT, width=20, height=3)
        self.entry5.grid(column=1, row=4,  sticky="nsew", padx=10, pady=5)
        self.dato5 = self.entry5

        self.botonEnviar=ttk.Button(self.modifyT,command=self.enviarTareaModify,text="Enviar")
        self.botonEnviar.grid(column=0,row=5,sticky="nsew",columnspan=2)
        self.botonBorrar=ttk.Button(self.modifyT,command=self.borrar,text="Borrar")
        self.botonBorrar.grid(column=0,row=6,sticky="nsew",columnspan=2)

    #BOTON MODIFICAR TAREA
    def enviarTareaModify(self):
        descripcion = self.dato5.get("1.0", tk.END).strip()
        if self.db.modificarTarea(self.dato2.get(),self.dato3.get(),self.dato4.get(),descripcion,self.dato1.get())==True:
            mb.showinfo("Información", "Se ha modificado correctamente la tarea.")
        else:
            mb.showerror("Error","Ha habido un fallo al modificar la tarea.")

        #VACIA LOS CAMPOS
        self.entry1.delete(0,tk.END)
        self.entry2.delete(0,tk.END)
        self.entry3.delete(0,tk.END)
        self.entry4.delete(0,tk.END)
        self.entry5.delete("1.0", tk.END)
    
    #CAMBIAR ESTADO A LA TAREA
    def cambiarEstadoT(self):
        self.cambioT = tk.Frame(self.ventana)
        self.cambioT.grid(column=0,row=0,sticky="nsew")

        self.cambioT.grid_rowconfigure(0, weight=1)
        self.cambioT.grid_rowconfigure(1, weight=1)
        self.cambioT.grid_rowconfigure(2, weight=1)
        self.cambioT.grid_rowconfigure(3, weight=1)

        self.labelFrameE = tk.LabelFrame(self.cambioT,text="ID")
        self.labelFrameE.grid(column=0, row=1)

        self.dato1 = tk.StringVar()
        self.label1 = ttk.Label(self.labelFrameE, text="Introduce la id de la tarea: ")
        self.label1.grid(column=0, row=0, sticky="nsew")
        self.entry = ttk.Entry(self.labelFrameE, textvariable=self.dato1)
        self.entry.grid(column=1, row=0, sticky="nsew")


        self.seleccion=tk.IntVar()
        self.seleccion.set(1)
        self.radio1 = tk.Radiobutton(self.cambioT, variable=self.seleccion, value=1, text="Por empezar")
        self.radio1.grid(column=1, row=1,padx=50)
        self.radio2 = tk.Radiobutton(self.cambioT, variable=self.seleccion, value=2, text="En proceso")
        self.radio2.grid(column=2, row=1,padx=50)
        self.radio3 = tk.Radiobutton(self.cambioT, variable=self.seleccion, value=3, text="Finalizado")
        self.radio3.grid(column=3, row=1,padx=50)

        self.boton = ttk.Button(self.cambioT, text="Cambiar", command=self.cambioDeEstadoTarea)
        self.boton.grid(column=0,row=3,columnspan=4)
    
    #BOTON DE CAMBIO DE ESTADO PARA TAREA
    def cambioDeEstadoTarea(self):
        if self.seleccion.get()==1:
            if self.db.cambioDeEstadoT("POR_EMPEZAR",self.dato1.get()):
                mb.showinfo("Info","Se ha cambiado de estado perfectamente")
            else:
                mb.showerror("Error","Ha habido un fallo al modificar el examen.")

        elif self.seleccion.get()==2:
            if self.db.cambioDeEstadoT("EN_PROCESO",self.dato1.get()):
                mb.showinfo("Info","Se ha cambiado de estado perfectamente")
            else:
                mb.showerror("Error","Ha habido un fallo al modificar el examen.")

        elif self.seleccion.get()==3:
            if self.db.cambioDeEstadoT("FINALIZADO",self.dato1.get()):
                mb.showinfo("Info","Se ha cambiado de estado perfectamente")
            else:
                mb.showerror("Error","Ha habido un fallo al modificar el examen.")


# MAIN
a = VentanaLogin()