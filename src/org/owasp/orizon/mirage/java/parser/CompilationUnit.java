/* Generated by: FreeCC 0.9.3. Do not edit. CompilationUnit.java */
package org.owasp.orizon.mirage.java.parser;

import java.util.*;
public class CompilationUnit extends BaseNode {
    public List<ImportDeclaration>importDeclarations=new ArrayList<ImportDeclaration>();
    public String getPackageName() {
        PackageDeclaration jpd=getPackageDeclaration();
        return jpd==null?null:
        jpd.getPackageName();
    }

    public PackageDeclaration getPackageDeclaration() {
        return Nodes.firstChildOfType(this,PackageDeclaration.class);
    }

    public List<ImportDeclaration>getImportDeclarations() {
        return Nodes.childrenOfType(this,ImportDeclaration.class);
    }

    public List<TypeDeclaration>getTypeDeclarations() {
        return Nodes.childrenOfType(this,TypeDeclaration.class);
    }

    public void addImportDeclaration(ImportDeclaration decl) {
        ListIterator<Node>iterator=iterator();
        Node n=null;
        while (!(n instanceof TypeDeclaration)) {
            n=iterator.next();
        }
        if (iterator.hasPrevious()) {
            iterator.previous();
            iterator.add(decl);
        }
        else {
            prepend(decl);
        }
    }

    public CompilationUnit(int id) {
        super(id);
    }

    public CompilationUnit() {
        super(JavaConstants.COMPILATIONUNIT);
    }

}