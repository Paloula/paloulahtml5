/*
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.paloula.xml.sequence;

import org.jdom2.Document;
import org.jdom2.Element;

import com.sun.istack.internal.NotNull;

import de.paloula.xml.commons.PaloulaXmlException;

public class Sequence {
	
	private Document xmlDocument;
	private ContentAttributes contentAttributes = new ContentAttributes();
	
	public Sequence(@NotNull Document xmlDocument) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionDocumentIsNull(xmlDocument);
		this.xmlDocument = xmlDocument;
	}
	
	public Sequence(@NotNull Document xmlDocument, @NotNull ContentAttributes contentAttributes) throws PaloulaXmlException {
		SequenceCheckExceptions.checkExceptionDocumentIsNull(xmlDocument);
		SequenceCheckExceptions.checkExceptionContentAttributesIsNull(contentAttributes);
		this.xmlDocument = xmlDocument;
		this.contentAttributes = contentAttributes;
	}

	/* ------------------------------------------------------------------------- */
	public void shiftNextWithinTagNameSiblings(@NotNull String shiftElementId) throws PaloulaXmlException {
		SequenceElement sequenceElement = new SequenceElement(this.xmlDocument, this.contentAttributes, true, shiftElementId);
		int targetPosition = sequenceElement.getAfterPosition();
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinTagNameSiblings(shiftElementId, targetPosition);
	}	
	
	public void shiftNextWithinTagNameSiblings(@NotNull Element shiftElement) throws PaloulaXmlException {
		SequenceElement sequenceElement = new SequenceElement(this.xmlDocument, this.contentAttributes, true, shiftElement);
		int targetPosition = sequenceElement.getAfterPosition();
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinTagNameSiblings(shiftElement, targetPosition);
	}	
	
	public void shiftNextWithinAllSiblings(@NotNull String shiftElementId) throws PaloulaXmlException {
		SequenceElement sequenceElement = new SequenceElement(this.xmlDocument, this.contentAttributes, false, shiftElementId);
		int targetPosition = sequenceElement.getAfterPosition();
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinAllSiblings(shiftElementId, targetPosition);
	}	
	
	public void shiftNextWithinAllSiblings(@NotNull Element shiftElement) throws PaloulaXmlException {
		SequenceElement sequenceElement = new SequenceElement(this.xmlDocument, this.contentAttributes, false, shiftElement);
		int targetPosition = sequenceElement.getAfterPosition();
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinAllSiblings(shiftElement, targetPosition);
	}	
	
	/* ------------------------------------------------------------------------- */
	public void shiftPreviousWithinTagNameSiblings(@NotNull String shiftElementId) throws PaloulaXmlException {
		SequenceElement sequenceElement = new SequenceElement(this.xmlDocument, this.contentAttributes, true, shiftElementId);
		int targetPosition = sequenceElement.getBeforePosition();
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinTagNameSiblings(shiftElementId, targetPosition);
	}	
	
	public void shiftPreviousWithinTagNameSiblings(@NotNull Element shiftElement) throws PaloulaXmlException {
		SequenceElement sequenceElement = new SequenceElement(this.xmlDocument, this.contentAttributes, true, shiftElement);
		int targetPosition = sequenceElement.getBeforePosition();
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinTagNameSiblings(shiftElement, targetPosition);
	}	
	
	public void shiftPreviousWithinAllSiblings(@NotNull String shiftElementId) throws PaloulaXmlException {
		SequenceElement sequenceElement = new SequenceElement(this.xmlDocument, this.contentAttributes, false, shiftElementId);
		int targetPosition = sequenceElement.getBeforePosition();
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinAllSiblings(shiftElementId, targetPosition);
	}	
	
	public void shiftPreviousWithinAllSiblings(@NotNull Element shiftElement) throws PaloulaXmlException {
		SequenceElement sequenceElement = new SequenceElement(this.xmlDocument, this.contentAttributes, false, shiftElement);
		int targetPosition = sequenceElement.getBeforePosition();
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinAllSiblings(shiftElement, targetPosition);
	}	
	
	/* ------------------------------------------------------------------------- */
	public void shiftWithinTagNameSiblings(@NotNull String shiftElementId, int targetPosition) throws PaloulaXmlException {
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinTagNameSiblings(shiftElementId, targetPosition);
	}	
	
	public void shiftWithinTagNameSiblings(@NotNull Element shiftElement, int targetPosition) throws PaloulaXmlException {
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinTagNameSiblings(shiftElement, targetPosition);
	}	

	public void shiftWithinAllSiblings(@NotNull String shiftElementId, int targetPosition) throws PaloulaXmlException {
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinAllSiblings(shiftElementId, targetPosition);
	}
	
	public void shiftWithinAllSiblings(@NotNull Element shiftElement, int targetPosition) throws PaloulaXmlException {
		SequenceShift sequenceShift = new SequenceShift(this.xmlDocument, this.contentAttributes);
		sequenceShift.shiftWithinAllSiblings(shiftElement, targetPosition);
	}	

	/* ------------------------------------------------------------------------- */
	public void insertAtWithinTagNameSiblings(@NotNull String siblingElementId, @NotNull Element insertElement, int targetPosition) throws PaloulaXmlException {
		SequenceInsertAt sequenceInsertAt = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsertAt.insertAtWithinTagNameSiblings(siblingElementId, insertElement, targetPosition);
	}
	
	public void insertAtWithinTagNameSiblings(@NotNull Element parentElement, @NotNull Element insertElement, int targetPosition) throws PaloulaXmlException {
		SequenceInsertAt sequenceInsertAt = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsertAt.insertAtWithinTagNameSiblings(parentElement, insertElement, targetPosition);
	}		
	
	public void insertAtWithinAllSiblings(@NotNull String siblingElementId, @NotNull Element insertElement, int targetPosition) throws PaloulaXmlException {
		SequenceInsertAt sequenceInsertAt = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsertAt.insertAtWithinAllSiblings(siblingElementId, insertElement, targetPosition);
	}	
	
	public void insertAtWithinAllSiblings(@NotNull Element parentElement, @NotNull Element insertElement, int targetPosition) throws PaloulaXmlException {
		SequenceInsertAt sequenceInsertAt = new SequenceInsertAt(this.xmlDocument, this.contentAttributes);
		sequenceInsertAt.insertAtWithinAllSiblings(parentElement, insertElement, targetPosition);
	}
	
	/* ------------------------------------------------------------------------- */
	public void insertBeforeWithinTagNameSiblings(@NotNull String beforeElementId, @NotNull Element insertElement) throws PaloulaXmlException {
		SequenceInsertBefore sequenceInsertBefore = new SequenceInsertBefore(this.xmlDocument, this.contentAttributes);
		sequenceInsertBefore.insertBeforeWithinTagNameSiblings(beforeElementId, insertElement);
	}

	public void insertBeforeWithinTagNameSiblings(@NotNull Element beforeElement, @NotNull Element insertElement) throws PaloulaXmlException {
		SequenceInsertBefore sequenceInsertBefore = new SequenceInsertBefore(this.xmlDocument, this.contentAttributes);
		sequenceInsertBefore.insertBeforeWithinTagNameSiblings(beforeElement, insertElement);
	}
	
	public void insertBeforeWithinAllSiblings(@NotNull String beforeElementId, @NotNull Element insertElement) throws PaloulaXmlException {
		SequenceInsertBefore sequenceInsertBefore = new SequenceInsertBefore(this.xmlDocument, this.contentAttributes);
		sequenceInsertBefore.insertBeforeWithinAllSiblings(beforeElementId, insertElement);
	}
	
	public void insertBeforeWithinAllSiblings(@NotNull Element beforeElement, @NotNull Element insertElement) throws PaloulaXmlException {	
		SequenceInsertBefore sequenceInsertBefore = new SequenceInsertBefore(this.xmlDocument, this.contentAttributes);
		sequenceInsertBefore.insertBeforeWithinAllSiblings(beforeElement, insertElement);
	}
	
	/* ------------------------------------------------------------------------- */
	public void insertAfterWithinTagNameSiblings(@NotNull String afterElementId, @NotNull Element insertElement) throws PaloulaXmlException {
		SequenceInsertAfter sequenceInsertAfter = new SequenceInsertAfter(this.xmlDocument, this.contentAttributes);
		sequenceInsertAfter.insertAfterWithinTagNameSiblings(afterElementId, insertElement);
	}

	public void insertAfterWithinTagNameSiblings(@NotNull Element afterElement, @NotNull Element insertElement) throws PaloulaXmlException {
		SequenceInsertAfter sequenceInsertAfter = new SequenceInsertAfter(this.xmlDocument, this.contentAttributes);
		sequenceInsertAfter.insertAfterWithinTagNameSiblings(afterElement, insertElement);
	}
	
	public void insertAfterWithinAllSiblings(@NotNull String afterElementId, @NotNull Element insertElement) throws PaloulaXmlException {
		SequenceInsertAfter sequenceInsertAfter = new SequenceInsertAfter(this.xmlDocument, this.contentAttributes);
		sequenceInsertAfter.insertAfterWithinAllSiblings(afterElementId, insertElement);
	}
	
	public void insertAfterWithinAllSiblings(@NotNull Element afterElement, @NotNull Element insertElement) throws PaloulaXmlException {	
		SequenceInsertAfter sequenceInsertAfter = new SequenceInsertAfter(this.xmlDocument, this.contentAttributes);
		sequenceInsertAfter.insertAfterWithinAllSiblings(afterElement, insertElement);
	}
	
	/* ------------------------------------------------------------------------- */
	public void deleteWithinTagNameSiblings(String deleteElementId) throws PaloulaXmlException {
		SequenceDelete sequenceDelete = new SequenceDelete(this.xmlDocument, this.contentAttributes);
		sequenceDelete.deleteWithinTagNameSiblings(deleteElementId);
	}
	
	public void deleteWithinTagNameSiblings(Element deleteElement) throws PaloulaXmlException {
		SequenceDelete sequenceDelete = new SequenceDelete(this.xmlDocument, this.contentAttributes);
		sequenceDelete.deleteWithinTagNameSiblings(deleteElement);
	}	
	
	public void deleteWithinAllSiblings(String deleteElementId) throws PaloulaXmlException {
		SequenceDelete sequenceDelete = new SequenceDelete(this.xmlDocument, this.contentAttributes);
		sequenceDelete.deleteWithinAllSiblings(deleteElementId);
	}
	
	public void deleteWithinAllSiblings(Element deleteElement) throws PaloulaXmlException {
		SequenceDelete sequenceDelete = new SequenceDelete(this.xmlDocument, this.contentAttributes);
		sequenceDelete.deleteWithinAllSiblings(deleteElement);
	}
	
	/* ------------------------------------------------------------------------- */
	public Document getXmlDocument() {
		return xmlDocument;
	}

	public ContentAttributes getContentAttributes() {
		return contentAttributes;
	}		
}
