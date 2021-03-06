/*
 * Copyright 2007-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 */

/**
 * @author Andres Almiray
 */

package griffon.samples.swingpad

actions {
    action(id: 'closeAction',
       name: app.getMessage('application.action.Close.name', 'Close'),
       closure: controller.hide,
       mnemonic: app.getMessage('application.action.Close.mnemonic', 'C'),
       shortDescription: app.getMessage('application.action.Close.description', 'Close')
    )
}

panel(id: 'content') {
    migLayout layoutConstraints: 'fill'
    tabbedPane(constraints: 'grow, wrap') {
        scrollPane(title: app.getMessage('application.dialog.Credits.writtenby', 'Written by'), constraints: 'grow') {
            textArea(editable: false, text: bind{ model.credits },
                caretPosition: bind('credits', source: model, converter: {0i}))
        }
    }   
    button(closeAction, constraints: 'right')

    keyStrokeAction(component: current,
        keyStroke: 'ESCAPE',
        condition: 'in focused window',
        action: closeAction)
}
