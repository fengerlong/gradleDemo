package com.example.plugin

import org.gradle.api.*

class MyPlugin implements Plugin<Project>{

    @Override
    void apply(Project project){
        //通过project的ExtensionContainer的create方法创建一个名为outerExt的扩展，扩展对应的类为OuterExt
        OuterExt outerExt = project.extensions.create('outerExt', OuterExt.class)

        //通过project的task方法创建一个名为showExt的Task
        project.task('showExt'){
            doLast{
                //使用OuterExt实例
                println "outerExt = ${outerExt}"
            }
        }
    }

    /**
     * 自定义插件的扩展对应的类
     */
    static class OuterExt{

        String message

        @Override
        String toString(){
            return "[message = ${message}]"
        }
    }
}
