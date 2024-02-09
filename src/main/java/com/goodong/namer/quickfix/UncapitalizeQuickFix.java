package com.goodong.namer.quickfix;

import com.goodong.namer.utils.StringUtils;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import org.jetbrains.annotations.NotNull;

public class UncapitalizeQuickFix implements LocalQuickFix {

    @Override
    public @IntentionFamilyName @NotNull String getFamilyName() {
        return "Name quick fix";
    }

    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
        PsiElement psiElement = descriptor.getPsiElement();
        if( psiElement instanceof PsiMethod) {
            PsiMethod method = (PsiMethod) psiElement;
            String name = method.getName();
            if (name.length() > 0) {
                String newName = StringUtils.toFirstLowerCase(name);
                method.setName(newName);
            }
        }
        else if (psiElement instanceof PsiField){
            PsiField field = (PsiField) psiElement;
            String name = field.getName();
            if (name.length() > 0) {
                String newName = StringUtils.toFirstLowerCase(name);
                field.setName(newName);
            }

        }

    }
}
