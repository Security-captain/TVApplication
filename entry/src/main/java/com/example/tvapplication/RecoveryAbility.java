package com.example.tvapplication;

import com.example.tvapplication.ResourceTable;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;

public class RecoveryAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_recovery_layout);
        Text txt=(Text)this.findComponentById(ResourceTable.Id_txt);
        if(txt!=null){
            txt.setText(intent.getStringParam("data"));
        }
    }
}
