package com.goodong.namer.quickfix;

import com.goodong.namer.utils.StringUtils;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import org.jetbrains.annotations.NotNull;

public class CapitalizeQuickFix implements LocalQuickFix {

    @Override
    public @IntentionFamilyName @NotNull String getFamilyName() {
        return  "Name quick fix";
    }

    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
        PsiClass clazz = (PsiClass) descriptor.getPsiElement();
        String className = clazz.getName();
        if (className != null && className.length() > 0) {
            String newClassName = StringUtils.toFirstUpperCase(className);
            clazz.setName(newClassName);
        }

    }
}
