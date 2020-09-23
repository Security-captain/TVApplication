package com.example.tvapplication.slice;

import com.example.tvapplication.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Text;

public class ListAbilitySlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_list_layout);
        Text txt=(Text)this.findComponentById(ResourceTable.Id_txt);
        if(txt!=null){
            txt.setText(intent.getStringParam("data"));
        }
    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
