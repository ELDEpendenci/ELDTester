package com.ericlam.mc.eldtester;

import com.ericlam.mc.eld.annotations.GroupResource;
import com.ericlam.mc.eld.annotations.Prefix;
import com.ericlam.mc.eld.components.GroupLangConfiguration;

@Prefix(path = "prefix")
@GroupResource(
        folder = "Langs",
        preloads = {"en-us", "zh-tw"}
)
public class TesterMultiLang extends GroupLangConfiguration {
}
