# paloulahtml5
Die Kombination aus Tomcat, XML und XSL ist eine der tollsten und effektivsten Methoden zur Entwicklung von hochdynamischen WebApps. Paloula hat das Ziel, Entwickler in diesem Prozess zu unterstützen.

Sequence erleichtert die Änderung der Reihenfolge in XML-Dokumenten(org.jdom2.Document), sowie das Einfügen und Löschen von Elementen(org.jdom2.Element) durch zahlreiche nützliche und praktische Methoden.

Sequence Shift-Methoden

shiftWithinTagNameSiblings(@NotNull String shiftElementId, int targetPosition);
shiftWithinTagNameSiblings(@NotNull Element shiftElement, int targetPosition);
shiftWithinAllSiblings(@NotNull String shiftElementId, int targetPosition);
shiftWithinAllSiblings(@NotNull Element shiftElement, int targetPosition);

Sequence InsertAt-Methoden

insertAtWithinTagNameSiblings(@NotNull String siblingElementId, @NotNull Element insertElement, int targetPosition);
insertAtWithinTagNameSiblings(@NotNull String siblingElementId, @NotNull Element insertElement, int targetPosition);
insertAtWithinAllSiblings(@NotNull String siblingElementId, @NotNull Element insertElement, int targetPosition);
insertAtWithinAllSiblings(@NotNull String siblingElementId, @NotNull Element insertElement, int targetPosition);

Sequence InsertBefore-Methoden

insertBeforeWithinTagNameSiblings(@NotNull String beforeElementId, @NotNull Element insertElement);
insertBeforeWithinTagNameSiblings(@NotNull Element beforeElement, @NotNull Element insertElement);
insertBeforeWithinAllSiblings(@NotNull String beforeElementId, @NotNull Element insertElement);
insertBeforeWithinAllSiblings(@NotNull Element beforeElement, @NotNull Element insertElement);

Sequence InsertAfter-Methoden

insertAfterWithinTagNameSiblings(@NotNull String afterElementId, @NotNull Element insertElement);
insertAfterWithinTagNameSiblings(@NotNull Element afterElement, @NotNull Element insertElement);
insertAfterWithinAllSiblings(@NotNull String afterElementId, @NotNull Element insertElement);
insertAfterWithinAllSiblings(@NotNull Element afterElement, @NotNull Element insertElement);

Sequence Delete-Methoden

deleteWithinTagNameSiblings(String deleteElementId);
deleteWithinTagNameSiblings(Element deleteElement);
deleteWithinAllSiblings(String deleteElementId);
deleteWithinAllSiblings(Element deleteElement);


https://github.com/Paloula/paloulahtml5/blob/master/documentation/Tutorial%20Sequence.docx
