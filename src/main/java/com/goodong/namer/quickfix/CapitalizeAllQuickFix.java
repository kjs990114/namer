package com.goodong.namer.quickfix;

import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiField;
import org.jetbrains.annotations.NotNull;

public class CapitalizeAllQuickFix implements LocalQuickFix {

    @Override
    public @IntentionFamilyName @NotNull String getFamilyName() {
        return "Name quick fix";
    }

    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
        PsiField field = (PsiField) descriptor.getPsiElement();
        String name = field.getName();
        StringBuilder sb = new StringBuilder();
        if (name.length() > 0) {
            for(int i = 0 ; i < name.length() ; i++){
                char ch = name.charAt(i);
                if(Character.isLowerCase(ch)){
                    ch = Character.toUpperCase(ch);
                }
                sb.append(ch);
            }
        }
        field.setName(sb.toString());
    }
}
