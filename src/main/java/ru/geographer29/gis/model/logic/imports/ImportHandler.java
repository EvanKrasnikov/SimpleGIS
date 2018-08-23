package ru.geographer29.gis.model.logic.imports;

import java.io.File;

class ImportHandler {
    private File file;

    ImportHandler(File file) {
        this.file = file;
    }

    void importWith(Importable importable){
        importable.importFile(file);
    }

}
