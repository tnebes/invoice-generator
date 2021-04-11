/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceGenerator.view.viewUtil;
import invoiceGenerator.controller.ArticleHandler;
import invoiceGenerator.model.Article;
import invoiceGenerator.model.Customer;
import invoiceGenerator.util.InvoiceGeneratorException;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author tnebes
 */
public class ArticlePicker extends javax.swing.JFrame {

    private ArticleHandler articleHandler;

    /**
     * Creates new form CustomerPicker
     */
    public ArticlePicker() {
        this.articleHandler = new ArticleHandler();
        initComponents();
        initArticles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstArticleList = new javax.swing.JList<>();
        btnChoose = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtArticlePickerSearch = new javax.swing.JTextField();
        btnArticlePickerSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        lstArticleList.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                lstArticleListComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(lstArticleList);

        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtArticlePickerSearch.setText("search...");

        btnArticlePickerSearch.setText("Search!");
        btnArticlePickerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticlePickerSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChoose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtArticlePickerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnArticlePickerSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArticlePickerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArticlePickerSearch))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancel)
                    .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        triggerCustomerCollection();
    }//GEN-LAST:event_btnChooseActionPerformed


    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void lstArticleListComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_lstArticleListComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_lstArticleListComponentShown

    private void btnArticlePickerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticlePickerSearchActionPerformed
        if (txtArticlePickerSearch.getText().isBlank()) {
            initArticles();
            return;
        }
        updateArticleList(txtArticlePickerSearch.getText());
    }//GEN-LAST:event_btnArticlePickerSearchActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArticlePickerSearch;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChoose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Article> lstArticleList;
    private javax.swing.JTextField txtArticlePickerSearch;
    // End of variables declaration//GEN-END:variables

    private void initArticles() {
        DefaultListModel<Article> articles = new DefaultListModel<>();
        try {
            articles.addAll(articleHandler.getData());
        } catch (InvoiceGeneratorException e) {
            e.printStackTrace();
        }
        lstArticleList.setModel(articles);
    }

    public Article returnChosenArticle() {
        Article selectedArticle = lstArticleList.getSelectedValue();
        return selectedArticle;
    }

    private void triggerCustomerCollection() {
        Article article = returnChosenArticle();
        if (article != null) {
            this.dispose();
            return;
        }
        JOptionPane.showMessageDialog(rootPane, "No article selected.");
    }

    public interface ArticleReturner {
        void run(Article article);
    }

    public void giveMeCustomer(ArticleReturner articleReturner) {
        btnChoose.addActionListener(e ->
            articleReturner.run(returnChosenArticle())
        );
    }

    private void updateArticleList(String text) {
        DefaultListModel<Article> listArticles = new DefaultListModel<>();
        try {
            List<Article> searchResult = articleHandler.getData(text);
            listArticles.addAll(searchResult);
            lstArticleList.setModel(listArticles);
        } catch (InvoiceGeneratorException e) {
            e.printStackTrace();
        }
    }

}