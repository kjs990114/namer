package com.goodong.namer.visitor;

import com.goodong.namer.quickfix.CapitalizeAllQuickFix;
import com.goodong.namer.quickfix.CapitalizeQuickFix;
import com.goodong.namer.quickfix.UncapitalizeQuickFix;
import com.goodong.namer.utils.StringUtils;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamerVisitor extends JavaElementVisitor {

    private final ProblemsHolder holder;
    public NamerVisitor(ProblemsHolder holder) {
        this.holder = holder;
    }

    @Override
    public void visitClass(PsiClass clazz) {
        super.visitClass(clazz);
        String name = clazz.getName();
        if(!("".equals(name)) && name != null) {
            if (!StringUtils.isFirstUpperCase(name)) {
                holder.registerProblem(clazz, "First Character cannot be lowercase", ProblemHighlightType.ERROR , new CapitalizeQuickFix());
            }
        }
    }

    @Override
    public void visitField(PsiField field) {
        super.visitField(field);

        PsiModifierList modifierList = field.getModifierList();
        String name = field.getName();
        /* constant */
        if(modifierList != null && modifierList.hasModifierProperty(PsiModifier.STATIC) && modifierList.hasModifierProperty(PsiModifier.FINAL)){

            Pattern pattern = Pattern.compile(StringUtils.CONST_REGEX);
            Matcher matcher = pattern.matcher(name);
            if(!matcher.matches()){
                holder.registerProblem(field,"Constant variable must be capitalized",ProblemHighlightType.ERROR, new CapitalizeAllQuickFix());
            }

        }
        /* other variable */
        else {
            if(StringUtils.isFirstUpperCase(name)){
                holder.registerProblem(field, "Variable can not start with uppercase", ProblemHighlightType.ERROR, new UncapitalizeQuickFix());
            }
        }
    }

    @Override
    public void visitIdentifier(PsiIdentifier identifier) {
        super.visitIdentifier(identifier);
    }

    @Override
    public void visitMethod(PsiMethod method) {
        super.visitMethod(method);
        String name = method.getName();
        if (!"".equals(name)){
            if(StringUtils.isFirstUpperCase(name)){
                holder.registerProblem(method, "First Character cannot be uppercase", ProblemHighlightType.ERROR , new UncapitalizeQuickFix());
            }
        }
    }


}
