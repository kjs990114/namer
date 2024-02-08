package com.goodong.namer;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;

public class MyPsiVisitor extends JavaElementVisitor {

    private final ProblemsHolder holder;

    public MyPsiVisitor(ProblemsHolder holder) {
        this.holder = holder;
    }

    @Override
    public void visitClass(PsiClass clazz) {
        super.visitClass(clazz);
        char firstCharacter = clazz.getName().charAt(0);

        if(Character.isLowerCase(firstCharacter)){
            holder.registerProblem(clazz, "First Character cannot be lowercase", ProblemHighlightType.ERROR);
        }
    }


}
